#!/usr/bin/env bash
# 禁止页面直接使用 Miuix 原始控件 必须走 com.lingyue.ksui
set -e
ROOT=$(cd "$(dirname "$0")/.." && pwd)
BAD=$(grep -rln "import top.yukonga.miuix" "$ROOT/app/src/main/java/com/example/kernelsustyleuikit/ui" 2>/dev/null \
  | grep -v "/component/" || true)
if [ -n "$BAD" ]; then
  echo "违禁 import 请在 com.lingyue.ksui 内封装后再用:"
  echo "$BAD"
  exit 1
fi
echo "OK: 页面未直接引用 Miuix 原始控件"
