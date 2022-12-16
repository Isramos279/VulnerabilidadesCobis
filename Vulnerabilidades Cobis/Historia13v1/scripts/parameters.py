import json
import sys

command=str(sys.argv[1])

#Init Vars
parameters = ''
sam_deploy=''
sam_deploy_parameters=''
sam_package=''
parameter_joined=''
repetition=0
lambda_config_tmp=''
lambda_config=''
value_repetition=False
separator=":"

with open('config.json') as f:
    config_environment = json.load(f)
    environment=config_environment['pipeline']
#Sam deploy
if environment and command=="deploy":
    general_parameters=environment['deploy']['parameters']
    deploy=environment['deploy']
    sam_deploy+="--stack-name "+deploy['stack-name']+" --s3-bucket "+deploy['s3-bucket']+" --s3-prefix "+deploy['prefix']+" --region "+deploy['aws-default-region']+" --capabilities "+deploy['capabilities']+" --no-confirm-changeset "+deploy['non-confirm-change-set']+" "
    for parameter in general_parameters:
        if type(parameter['parameterValue']) == str:
            sam_deploy_parameters += '{0}="{1}" '.format(parameter['parameterKey'], parameter['parameterValue'])
        else:
            sam_deploy_parameters += '{0}={1} '.format(parameter['parameterKey'], parameter['parameterValue'])

        if parameter['parameterKey'] == 'Module':
            sam_deploy_parameters += 'ModuleTagToLower="{}" '.format(parameter['parameterValue'].lower())
        if parameter['parameterKey'] == 'DeploymentTime':
            sam_deploy_parameters += '{0}={1} '.format(parameter['parameterKey'], parameter['parameterValue'])

    print(sam_deploy+" --parameter-overrides "+sam_deploy_parameters ,end = '')

#Sam package
if environment and command=="package":
    deploy=environment['deploy']
    sam_package+=" --s3-bucket "+deploy['s3-bucket']+" --s3-prefix "+deploy['prefix']+" --region "+deploy['aws-default-region']+" "
    print(sam_package, end = '')