#!/bin/bash

# Variables
APIGatewayName=$(jq '.config | .[] | select(.parameterKey=="APIGatewayName") | .parameterValue ' config_variables.json -r)
YAML_OUTPUT_DIR=resources/specs/api
mkdir -p $YAML_OUTPUT_DIR
DNS_DESC_DEV='description: Internal development server for testing'
DNS_DESC_STG='description: Internal staging server for testing'
YAML_SERVERS='\n  - url: '$DNS_ENDPOINT_DEV'\n    '$DNS_DESC_DEV'\n  - url: '$DNS_ENDPOINT_STG'\n    '$DNS_DESC_STG

echo "=========== Replace Specs Servers ============="
sed 's/Fn::Sub: ${EnvironmentId} - ${APIGatewayName}/'$APIGatewayName'/g' specs/v1/$YAML_FILE_NAME > $YAML_OUTPUT_DIR/$YAML_FILE_NAME
sed '/- url: http/,/staging server for testing/d' $YAML_OUTPUT_DIR/$YAML_FILE_NAME > $YAML_OUTPUT_DIR/COBISCustomersAPI_copy.yaml
rm -rf $YAML_OUTPUT_DIR/$YAML_FILE_NAME
mv $YAML_OUTPUT_DIR/COBISCustomersAPI_copy.yaml $YAML_OUTPUT_DIR/$YAML_FILE_NAME

sed "s|servers:|servers:$YAML_SERVERS|g" $YAML_OUTPUT_DIR/$YAML_FILE_NAME > $YAML_OUTPUT_DIR/COBISCustomersAPI_copy.yaml
rm -rf $YAML_OUTPUT_DIR/$YAML_FILE_NAME
mv $YAML_OUTPUT_DIR/COBISCustomersAPI_copy.yaml $YAML_OUTPUT_DIR/$YAML_FILE_NAME


echo "[INI] - Descargando Swagger CodeGen "
wget -P $YAML_OUTPUT_DIR https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.5/swagger-codegen-cli-3.0.5.jar
echo "[END] - Descargando Swagger CodeGen "

echo "[INI] - Validar especificación y entidades de negocio"
speccy lint $YAML_OUTPUT_DIR/$YAML_FILE_NAME
echo "[END] - Validar especificación y entidades de negocio"

echo "[INI] - Generar JSON"
yaml-convert -j $YAML_OUTPUT_DIR/$YAML_FILE_NAME -p -o $YAML_OUTPUT_DIR/$JSON_FILE_NAME
echo "[END] - Generar JSON"

echo "[INI] - Generar JSON resuelto"
swagger-cli bundle -r -t json $YAML_OUTPUT_DIR/$JSON_FILE_NAME -o $YAML_OUTPUT_DIR/open-resolved.json
echo "[END] - Generar JSON resuelto"

echo "[INI] - Depurar JSON resuelto"
jq -M 'del(.components.schemas)' $YAML_OUTPUT_DIR/open-resolved.json -c > $YAML_OUTPUT_DIR/COBISCustomersAPI-resolved.json
rm -rf $YAML_OUTPUT_DIR/open-resolved.json
echo "[END] - Depurar JSON resuelto"

echo "[INI] - Generar YAML resuelto"
mkdir -p $YAML_OUTPUT_DIR/RESOLVE
java -jar ${YAML_OUTPUT_DIR}/swagger-codegen-cli-3.0.5.jar generate -i $YAML_OUTPUT_DIR/$YAML_FILE_NAME -l openapi-yaml -o $YAML_OUTPUT_DIR/RESOLVE
mv $YAML_OUTPUT_DIR/RESOLVE/openapi.yaml $YAML_OUTPUT_DIR/$YAML_FILE_RESOLVED_NAME
rm -rf $YAML_OUTPUT_DIR/RESOLVE
echo "[END] - Generar YAML resuelto"

echo "[INI] - Publish YAML - JSON"
aws s3 cp $YAML_OUTPUT_DIR/COBISCustomersAPI-resolved.json ${S3_BUCKET_OPENAPI}
aws s3 cp $YAML_OUTPUT_DIR/$YAML_FILE_RESOLVED_NAME ${S3_BUCKET_OPENAPI}
echo "[END] - Publish YAML - JSON"