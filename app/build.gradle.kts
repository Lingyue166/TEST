@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.lsplugin.apksign)
    id("kotlin-parcelize")
}

val androidCompileSdkVersion = rootProject.extra["androidCompileSdkVersion"] as Int
val androidCompileSdkVersionMinor = rootProject.extra["androidCompileSdkVersionMinor"] as Int
val androidBuildToolsVersion = rootProject.extra["androidBuildToolsVersion"] as String
val androidMinSdkVersion = rootProject.extra["androidMinSdkVersion"] as Int
val androidTargetSdkVersion = rootProject.extra["androidTargetSdkVersion"] as Int
val androidSourceCompatibility = rootProject.extra["androidSourceCompatibility"] as JavaVersion
val androidTargetCompatibility = rootProject.extra["androidTargetCompatibility"] as JavaVersion
val managerVersionCode = rootProject.extra["managerVersionCode"] as Int
val managerVersionName = rootProject.extra["managerVersionName"] as String

apksign {
    storeFileProperty = "KEYSTORE_FILE"
    storePasswordProperty = "KEYSTORE_PASSWORD"
    keyAliasProperty = "KEY_ALIAS"
    keyPasswordProperty = "KEY_PASSWORD"
}

android {
    packaging {
        resources {
            excludes += setOf("META-INF/LICENSE.md", "META-INF/LICENSE-notice.md", "META-INF/NOTICE.md")
        }
    }

    namespace = "com.example.kernelsustyleuikit"
    val isPrBuild = project.findProperty("IS_PR_BUILD")?.toString()?.toBoolean() ?: false

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            vcsInfo.include = false
            if (isPrBuild) applicationIdSuffix = ".dev"
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    packaging {
        dex {
            useLegacyPackaging = true
        }
        jniLibs {
            useLegacyPackaging = true
            excludes += "lib/*/libandroidx.graphics.path.so"
        }
    }

    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }

    androidResources {
        generateLocaleConfig = true
        // Keep unfinished translations in source without advertising or shipping them.
        localeFilters += listOf("en", "zh-rCN", "zh-rTW", "zh-rHK")
    }
    compileSdk {
        version =
            release(androidCompileSdkVersion) {
                minorApiLevel = androidCompileSdkVersionMinor
            }
    }
    buildToolsVersion = androidBuildToolsVersion

    defaultConfig {
        applicationId = "com.example.kernelsustyleuikit"
        minSdk = androidMinSdkVersion
        targetSdk = androidTargetSdkVersion
        versionCode = managerVersionCode
        versionName = managerVersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("boolean", "IS_PR_BUILD", isPrBuild.toString())
    }

    lint {
        abortOnError = true
        checkReleaseBuilds = true
    }

    testOptions {
        unitTests.all {
            it.systemProperty("app.resourcesDir", file("src/main/res").absolutePath)
            it.systemProperty("app.localeFilters", androidResources.localeFilters.joinToString(","))
            it.inputs.files(fileTree("src/main/res") { include("values*/strings.xml") })
                .withPropertyName("translationFiles")
        }
    }

    compileOptions {
        sourceCompatibility = androidSourceCompatibility
        targetCompatibility = androidTargetCompatibility
    }
}

androidComponents {
    onVariants(selector().withBuildType("release")) {
        it.packaging.resources.excludes.addAll(listOf("META-INF/**", "kotlin/**", "**.bin"))
    }
}

base {
    archivesName.set(
        "KernelSUStyleUIKit_v${managerVersionName}_${managerVersionCode}"
    )
}

dependencies {
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)

    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.navigationevent.compose)

    implementation(libs.kotlinx.coroutines.core)
    implementation(files("libs/gson-2.11.0.jar"))
    implementation(files("libs/bcpg-jdk18on-1.86.jar"))
    implementation(files("libs/bcpkix-jdk18on-1.79.jar"))
    implementation(files("libs/bcprov-jdk18on-1.86.jar"))
    implementation(files("libs/bcutil-jdk18on-1.86.jar"))
    implementation(files("libs/commons-compress-1.27.1.jar"))
    implementation(files("libs/xz-1.12.jar"))

    implementation(libs.commonmark)
    implementation(libs.commonmark.ext.gfm.tables)
    implementation(libs.commonmark.ext.gfm.strikethrough)
    implementation(libs.commonmark.ext.autolink)
    implementation(libs.commonmark.ext.task.list.items)

    implementation(libs.androidx.webkit)

    implementation(libs.hiddenapibypass)

    implementation(libs.miuix.ui)
    implementation(libs.miuix.icons)
    implementation(libs.miuix.nav)
    implementation(libs.miuix.preference)
    implementation(libs.miuix.blur)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)

    implementation(libs.material.kolor)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.runner)

}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3ExpressiveApi",
        )
    }
}

// UI Guard: 页面禁止直接使用 Miuix 原始控件 必须走控件库封装
val uiGuard by tasks.registering {
    val scanDirs = listOf(
        file("src/main/java/com/example/kernelsustyleuikit/ui/screen"),
        file("src/main/java/com/lingyue/layerbridge/ui"),
    )
    val allowFile = rootProject.file("ui-guard-allow.txt")
    doLast {
        val banned = Regex("""^\s*import\s+top\.yukonga\.miuix""", RegexOption.MULTILINE)
        val allow = if (allowFile.exists()) allowFile.readLines().map { it.trim() }.filter { it.isNotEmpty() && !it.startsWith("#") } else emptyList()
        val violations = scanDirs.filter { it.exists() }
            .flatMap { dir -> dir.walkTopDown().filter { it.isFile && it.extension == "kt" }.toList() }
            .filter { f -> allow.none { token -> f.path.replace('\\','/').contains(token) } }
            .filter { f -> banned.containsMatchIn(f.readText()) }
        if (violations.isNotEmpty()) {
            throw GradleException(
                "UI Guard: 页面禁止直接 import Miuix 原始控件 请先封装到 com.lingyue.ksui 或组件层\n" +
                    violations.joinToString("\n") { " - " + it.path }
            )
        }
    }
}
tasks.matching { it.name == "preBuild" }.configureEach { dependsOn(uiGuard) }

// UI 注释守卫: 每个 @Composable 控件上方必须带设计保证注释 否则编译失败
val uiAnnotationGuard by tasks.registering {
    val marker = "<我保证已经认真阅读过skill，确认符合设计语言以及用户要求，没有私自创建控件>"
    val scanDirs = listOf(
        file("src/main/java/com/example/kernelsustyleuikit/ui"),
        file("src/main/java/com/lingyue/layerbridge/ui"),
    )
    val allowFile = rootProject.file("ui-annotation-allow.txt")
    doLast {
        val allow = if (allowFile.exists()) allowFile.readLines().map { it.trim() }.filter { it.isNotEmpty() && !it.startsWith("#") } else emptyList()
        val violations = mutableListOf<String>()
        scanDirs.filter { it.exists() }.forEach { dir ->
            dir.walkTopDown().filter { it.isFile && it.extension == "kt" }.forEach { f ->
                val normalized = f.path.replace('\\','/')
                if (allow.any { normalized.contains(it) }) return@forEach
                val lines = f.readLines()
                lines.forEachIndexed { index, line ->
                    if (line.trim().startsWith("@Composable")) {
                        val from = (index - 15).coerceAtLeast(0)
                        val hasMarker = lines.subList(from, index + 1).any { it.contains(marker) }
                        if (!hasMarker) {
                            val fnLine = lines.drop(index + 1).firstOrNull { it.contains("fun ") }?.trim().orEmpty()
                            violations += "$normalized:${index + 1} $fnLine"
                        }
                    }
                }
            }
        }
        if (violations.isNotEmpty()) {
            throw GradleException(
                "UI 注释守卫: 以下 @Composable 控件缺少设计保证注释\n$marker\n" + violations.joinToString("\n") { " - $it" }
            )
        }
    }
}
tasks.matching { it.name == "preBuild" }.configureEach { dependsOn(uiAnnotationGuard) }
