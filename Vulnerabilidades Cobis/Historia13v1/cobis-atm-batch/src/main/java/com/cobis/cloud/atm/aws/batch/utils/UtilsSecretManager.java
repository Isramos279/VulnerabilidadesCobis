package com.cobis.cloud.atm.aws.batch.utils;

import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

@Log4j2
public class UtilsSecretManager {

    UtilsSecretManager()
    {
        throw new IllegalStateException("UtilsSecretManager no puede ser usada para crear extancias");
    }

    public static String getSecret(String secretName, String region) {

        Region regionObject = Region.of(region);

        try (SecretsManagerClient secretsClient = SecretsManagerClient.builder().region(regionObject).build())
        {
            GetSecretValueRequest valueRequest = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            return secretsClient.getSecretValue(valueRequest).secretString();

        } catch (SecretsManagerException e) {
            log.error("SecretsManagerException getting secret value: " + e.awsErrorDetails().errorMessage(), e);
            return null;
        }
    }
}