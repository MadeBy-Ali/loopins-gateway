#!/bin/bash

set -e

echo "🚀 Loopins Gateway - Quick Start"
echo "================================="
echo ""

# Load .env if exists
if [ -f ".env" ]; then
    echo "📝 Loading environment variables from .env..."
    set -a
    source .env
    set +a
else
    echo "⚠️  No .env file found, using defaults from application.yml"
fi

# Build
echo "🔨 Building the gateway..."
mvn clean package -DskipTests -q
echo "✅ Build complete"
echo ""

# Run
echo "🎯 Starting gateway on port ${GATEWAY_PORT:-8000}..."
echo "========================================"
echo "   Gateway: http://localhost:${GATEWAY_PORT:-8000}"
echo ""
echo "   Routes:"
echo "   /api/**         → loopins-core   (${CORE_SERVICE_URL:-http://localhost:8080})"
echo "   /fulfillment/** → loopins-fulfill (${FULFILLMENT_SERVICE_URL:-http://localhost:8081})"
echo ""
echo "Press Ctrl+C to stop"
echo "========================================"
echo ""

java -jar target/*.jar
