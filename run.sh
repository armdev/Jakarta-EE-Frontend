#!/usr/bin/env bash

set -e
# https://kb.objectrocket.com/redis/run-redis-with-docker-compose-1055
echo "Build all project"
mvn clean package -U -Dmaven.test.skip=true
echo "Down all"
docker-compose down
echo "Start Full System "
docker-compose  up -d --build
echo "Show logs"
docker logs --follow web







