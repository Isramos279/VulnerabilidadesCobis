#!/bin/bash
set -e
set -u

ENV_BASE='dev'
ENV_ID='syncbranchs'
ENV_TYPE='DEVELOPMENT'
AWS_DEFAULT_REGION='us-east-2'
AWS_DEFAULT_ACCOUNT='225742832627'
USER_POOL_ID='us-east-2_CTDFlMV3d'
SECURITY_GROUP_IDS='sg-0c1e32db86ecb9153'
KMS_KEY_ID='ae041e33-524d-49a6-8e3e-3f0a9a4babfb'
SUBNET_IDS='subnet-07e40da865a120cab,subnet-04b18811e75ba67f2'
S3_BUCKET='aws-sam-cli-managed-default-samclisourcebucket-ogwoc12b0aji'

echo -e '[START]: DEPLOY STACK\n'
echo -e '\nSAM BUILD'
sam build

echo -e '\nSAM PACKAGE'
sam package --s3-bucket ${S3_BUCKET} --s3-prefix ${ENV_ID}-ddaccounts --region ${AWS_DEFAULT_REGION} --output-template-file out.yaml

echo -e '\nSAM DEPLOY'
LEN_PARAMS=$(jq '.config | length' config_variables.json)

PARAMS_DEFAULT=""
for ((i = 0; i < ${LEN_PARAMS}; i++)); do
    PARAMS_KEY=$(jq ".config | .[${i}] | .parameterKey" config_variables.json -r)
    PARAMS_VALUE=$(jq ".config | .[${i}] | .parameterValue" config_variables.json -r)
    PARAMS_DEFAULT+="${PARAMS_KEY}=${PARAMS_VALUE} "
done

PARAMS_DEFAULT+="ModuleTagToLower=$(jq '.config | .[] | select(.parameterKey=="Module") | with_entries(.value |= ascii_downcase ) | .parameterValue' config_variables.json -r)"

sam deploy --stack-name ${ENV_ID}-ddaccounts --s3-bucket ${S3_BUCKET} --s3-prefix ${ENV_ID}-ddaccounts --region ${AWS_DEFAULT_REGION} --capabilities CAPABILITY_IAM CAPABILITY_AUTO_EXPAND CAPABILITY_NAMED_IAM --no-confirm-changeset true --parameter-overrides ${PARAMS_DEFAULT} DbTarget=readreplica skipparameterstore=true EnvironmentType=${ENV_TYPE} EnvironmentIdBase=${ENV_BASE} EnvironmentId=${ENV_ID} RegionToDeploy=${AWS_DEFAULT_REGION} AwsAccountIdToDeploy=${AWS_DEFAULT_ACCOUNT} UserDatabaseReadReplica=user=admin PasswordDatabaseReadReplica=password=C0bis2019 UserDatabaseMaster=user=admin PasswordDatabaseMaster=password=C0bis2019 SharedResourcesAccount=858761987689 UserPoolId=${USER_POOL_ID} ValueApiKey=qwertyuioplkjhgfdsaBSG KmsKeyId=ae041e33-524d-49a6-8e3e-3f0a9a4babfb SecurityGroupIds=${SECURITY_GROUP_IDS} SubnetIds=${SUBNET_IDS} StageName=StageDev EnvironmentIdBaseFront=${ENV_ID} DBReading="jdbc:mysql://dev-gp-mysql-aurora-cluster-rds-cluster.cluster-ro-cn2sc4zc3b8i.us-east-2.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=latin1_spanish_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" DBProxy="jdbc:mysql://stg-gp-mysql-aurora-cluster-rds-proxy.proxy-c8urkd4pc2xs.us-west-2.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=latin1_spanish_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" -t out.yaml

echo -e '[START]: DEPLOY STACK\n'
