#!/bin/bash

export LC_ALL="C"
set -euo pipefail

exec java -jar "$(dirname "$0")/target/paper-rock-scissors-1.0.0.jar"
