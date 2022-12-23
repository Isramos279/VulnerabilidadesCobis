#!/bin/sh
set -e
export BUCKET_INPUT=$1
export FILE_NAME=$2
if [[ -z "${APP_DATASOURCE_MASTER_ENDPOINT}" ]] || [[ -z "${APP_DATASOURCE_MASTER_PORT}" ]] || [[ -z "${APP_DATASOURCE_MASTER_ARGUMENTS}" ]] || [[ -z "${APP_DATASOURCE_MASTER_DATABASE}" ]] || [[ -z "${APP_DATASOURCE_MASTER_REPLICA_ENDPOINT}" ]] || [[ -z "${APP_DATASOURCE_MASTER_REPLICA_PORT}" ]] || [[ -z "${SPRING_DATASOURCE_USERNAME}" ]]; then
    java -noverify -Duser.country=EC -Duser.language=es -Dspring.profiles.active=$PROFILE $JAVA_OPTS -jar app.jar
else
    java -noverify -Duser.country=EC -Duser.language=es "-Dspring.datasource.url=jdbc-secretsmanager:mysql:replication://[${APP_DATASOURCE_MASTER_ENDPOINT}:${APP_DATASOURCE_MASTER_PORT}, ${APP_DATASOURCE_MASTER_REPLICA_ENDPOINT}:${APP_DATASOURCE_MASTER_REPLICA_PORT}]/${APP_DATASOURCE_MASTER_DATABASE}?${APP_DATASOURCE_MASTER_ARGUMENTS}" "-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}" -Dspring.profiles.active=$PROFILE $JAVA_OPTS -jar app.jar
fi
