@Library('cobis-cloud-devops@v3.2.1')

import com.cobis.devops.dto.BackendCoreMicroserviceTemplateInfo


String cobisLanguageVersion = "3.2.6"
String backendPathsFilename = "config/BackendPaths.txt"
String projectKey = "cobis-atm-backend-aws"
// El parámetro "javaProjectPath" debe teminar SIN /
String javaProjectPath = "test/cobis-atm-backend-aws"

String phonesDevopsAlert = "['+593 98-786-4795']"
String awsArnTopic = "arn:aws:sns:us-east-2:225742832627:cobis-atm-backend-aws"
String teamsName = "ATM-Backend"
String teamsLink = ""


BackendCoreMicroserviceTemplateInfo backendCoreMicroserviceTemplateInfo = new BackendCoreMicroserviceTemplateInfo(
    cobisLanguageVersion, backendPathsFilename, projectKey, javaProjectPath, 
    phonesDevopsAlert, awsArnTopic, teamsName, teamsLink
)

backendCoreMicroserviceTemplate(backendCoreMicroserviceTemplateInfo)
