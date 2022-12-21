@echo off

SET parameters=%undefined%
echo %parameter%
cd ..
sam build

# Para Desarrollo Nuevo DM1
sam package --s3-bucket aws-sam-cli-managed-default-samclisourcebucket-1rs8miw3huk54 --s3-prefix CHANNELS-YLA --region us-east-1 --output-template-file out.yaml

sam deploy --stack-name CHANNELS-YLA --s3-bucket aws-sam-cli-managed-default-samclisourcebucket-1rs8miw3huk54 --s3-prefix CHANNELS-YLA --region us-east-1 --capabilities CAPABILITY_IAM CAPABILITY_AUTO_EXPAND CAPABILITY_NAMED_IAM --no-confirm-changeset true --parameter-overrides DbTarget=master LogLevel=INFO Module=Channels MonitoringEventSource=cobis.lambda.function MonitoringEventType=business-logic-execution-event ParametersStoreCacheExpirationTime=120 RegisterAuditLambda=cobis-audit-create-record UpdateAuditLambda=cobis-audit-update-record LambdaAuthorizer=auth-authorization-challenge skipParameterStore=true ModuleTagToLower=channels Organization=Cobiscorp Package="COBIS CORE BANKING" Version="0.1" EnvironmentType="DEVELOPMENT" EnvironmentIdBaseFront="yla" AwsAccountIdToDeploy="681989517074" EnvironmentIdBase="dev" EnvironmentId="yla" TenantId="t1" Project="Core Serverless" Product="Channels" ProcessingType="ONLINE" UserDatabaseReadReplica="user=admin" PasswordDatabaseReadReplica="password=C0bis2019" UserDatabaseMaster="user=admin" PasswordDatabaseMaster="password=C0bis2019" SharedResourcesAccount="125277160564" UserPoolId="us-east-1_wm61L3yxy" DaysRetention=7 ValueApiKey="yalpmqwertyuioplkjhgfdpp64" SubnetIds="subnet-0eddad8c54d7b4c12,subnet-04451e9e1e67a29a1" KmsKeyId="530e1864-b01a-4fa9-9762-eaf7c3b268ed" DBReading="jdbc:mysql://dm1-gp-mysql-aurora-cluster-rds.cluster-ck9mgilqxnyv.us-east-1.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=utf8_general_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" ConnectionUrl="jdbc:mysql://dm1-gp-mysql-aurora-cluster-rds.cluster-ck9mgilqxnyv.us-east-1.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=utf8_general_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" StageName="StageDev" RetrieveAuditLambda="cobis-audit-get-record" APIGatewayName="COBIS_API_CHANNELS" DaysRetentionQA=7 LambdaAliasBeta="beta" LambdaAliasProduction="production" StageMainVersionName="v1" DaysRetentionDev=1 SecurityGroupIds="sg-0a05685831d407f2c" RegionToDeploy="us-east-1" DBConnectionExpirationTime=300 DaysRetentionProd=30 DashboardName="COBIS_API_CHANNELS" DBProxy="jdbc:mysql://dm1-gp-mysql-aurora-cluster-rds.cluster-ck9mgilqxnyv.us-east-1.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=utf8_general_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" EnvironmentIdInternal=dev SecretArn="arn:aws:secretsmanager:us-east-1:681989517074:secret:/dm1/DemandDepositsSrv/database/credentials-lwJ5E5" EcsTaskExecutionRole="arn:aws:iam::681989517074:role/dm1-batch-task-execution-role" AWSBatchServiceRole="arn:aws:iam::681989517074:role/dm1-batch-compute-service-role" TracingMode=false AWSBatchServiceRole="arn:aws:iam::681989517074:role/dm1-batch-compute-service-role" EnvironmentIdBaseAutorizer=dev -t out.yaml

# Para Desarrollo antiguo

sam package --s3-bucket aws-sam-cli-managed-default-samclisourcebucket-ogwoc12b0aji --s3-prefix CHANNELS-YLA --region us-east-2 --output-template-file out.yaml

sam deploy --stack-name CHANNELS-YLA --s3-bucket aws-sam-cli-managed-default-samclisourcebucket-ogwoc12b0aji --s3-prefix CHANNELS-YLA --region us-east-2 --capabilities CAPABILITY_IAM CAPABILITY_AUTO_EXPAND CAPABILITY_NAMED_IAM --no-confirm-changeset true --parameter-overrides DbTarget=master LogLevel=INFO Module=Channels MonitoringEventSource=cobis.lambda.function MonitoringEventType=business-logic-execution-event ParametersStoreCacheExpirationTime=120 RegisterAuditLambda=cobis-audit-create-record UpdateAuditLambda=cobis-audit-update-record LambdaAuthorizer=auth-authorization-challenge skipParameterStore=true ModuleTagToLower=channels Organization=Cobiscorp Package="COBIS CORE BANKING" Version="0.1" EnvironmentType="DEVELOPMENT" EnvironmentIdBaseFront="yla" AwsAccountIdToDeploy="225742832627" EnvironmentIdBase="dev" EnvironmentId="yla" TenantId="t1" Project="Core Serverless" Product="Channels" ProcessingType="ONLINE" UserDatabaseReadReplica="user=admin" PasswordDatabaseReadReplica="password=C0bis2019" UserDatabaseMaster="user=admin" PasswordDatabaseMaster="password=C0bis2019" SharedResourcesAccount="125277160564" UserPoolId="us-east-2_CTDFlMV3d" DaysRetention=7 ValueApiKey="yalpmqwertyuioplkjhgfdpp64" SubnetIds="subnet-07e40da865a120cab,subnet-04b18811e75ba67f2" KmsKeyId="ae041e33-524d-49a6-8e3e-3f0a9a4babfb" DBReading="jdbc:mysql://dev-gp-mysql-aurora-cluster-rds-cluster.cluster-cn2sc4zc3b8i.us-east-2.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=latin1_spanish_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" ConnectionUrl="jdbc:mysql://dev-gp-mysql-aurora-cluster-rds-cluster.cluster-cn2sc4zc3b8i.us-east-2.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=latin1_spanish_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" StageName="StageDev" RetrieveAuditLambda="cobis-audit-get-record" APIGatewayName="COBIS_API_CHANNELS" DaysRetentionQA=7 LambdaAliasBeta="beta" LambdaAliasProduction="production" StageMainVersionName="v1" DaysRetentionDev=1 SecurityGroupIds="sg-0c1e32db86ecb9153" RegionToDeploy="us-east-2" DBConnectionExpirationTime=300 DaysRetentionProd=30 DashboardName="COBIS_API_CHANNELS" DBProxy="jdbc:mysql://dev-gp-mysql-aurora-cluster-rds-cluster.cluster-cn2sc4zc3b8i.us-east-2.rds.amazonaws.com:3306/cobis?strictUpdates=false&connectionCollation=latin1_spanish_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT" EnvironmentIdInternal=dev SecretArn="arn:aws:secretsmanager:us-east-2:225742832627:secret:/cds/SavingsAccounts/t1/database/credentials-24tJMj" EcsTaskExecutionRole="arn:aws:iam::225742832627:role/ecsTaskExecutionRole" AWSBatchServiceRole="arn:aws:iam::225742832627:role/AWSBatchServiceRole" TracingMode=false EnvironmentIdBaseAutorizer=dev -t out.yaml
