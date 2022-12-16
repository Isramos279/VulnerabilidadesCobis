package com.cobis.cloud.atm.aws.batch.lambda;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
@RunWith(MockitoJUnitRunner.class)
class FileProcessingTest {

    @Test
    void handleRequestTestSucess() throws Exception {

        String region = "us-east-1";
        String secretName = "arn:aws:secretsmanager:us-east-1:681989517074:secret:/tmp/ATMSrv/database/credentials-fh8oN";
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream eventStream = this.getClass().getResourceAsStream("/InputLambdaUpdateSuccess.json");
        FileProcessing handler = new FileProcessing();
        Object object = objectMapper.readValue(eventStream, Object.class);

        String resultado = handler.handleRequest(object, null);
        assertEquals("Ejecución de Lambda exitosa", resultado);
    }

        /*
        try (MockedStatic<UtilsSecretManager> mockSecret = Mockito.mockStatic(UtilsSecretManager.class);
             MockedStatic<DriverManager> mockDriver = Mockito.mockStatic(DriverManager.class)) {
            mockSecret.when(() -> UtilsSecretManager.getSecret(secretName, region))
                    .thenReturn("{\n" +
                            "  \"username\": \"useratm\",\n" +
                            "  \"password\": \"U53rC4n4l35D3v\",\n" +
                            "  \"engine\": \"aurora-mysql\",\n" +
                            "  \"database\": \"cobis\",\n" +
                            "  \"arguments\": \"strictUpdates=false&connectionCollation=utf8_general_ci&sessionVariables=sql_mode=PIPES_AS_CONCAT\",\n" +
                            "  \"masterEndpoint\": \"master.dev1.database.general.cobiscorp.cobiscloud.int\",\n" +
                            "  \"masterPort\": \"3333\",\n" +
                            "  \"readReplicaEndpoint\": \"readreplica.dev1.database.general.cobiscorp.cobiscloud.int\",\n" +
                            "  \"readReplicaPort\": \"3333\"\n" +
                            "}");
            Gson gson = new Gson();
            DataBaseCredentials credentials = gson.fromJson(UtilsSecretManager.getSecret(secretName, region), DataBaseCredentials.class);
            String jdbcConnection = String.format("jdbc:mysql://%s:%s/%s?%s", credentials.getMasterEndpoint(),  credentials.getMasterPort(), credentials.getDatabase(), credentials.getPassword());
            mockDriver.when(() -> DriverManager.getConnection(jdbcConnection, "useratm", "password"))
                    .thenReturn(Mockito.mock(Connection.class));
            Context context = spy(new Context(DriverManager.getConnection(jdbcConnection, "useratm", "password")));
            Mockito.doReturn(new ProcedureResponse())
                    .when(context)
                    .invokeGenericApi(Mockito.anyMap(),Mockito.anyList());
            String result = withEnvironmentVariable(
                    "SECRET_ARN", secretName)
                    .and("AWS_REGION", region)
                    .execute(() -> {
                        String resultado = handler.handleRequest(object, null);
                        return resultado;
                    });
            assertEquals("Ejecución de Lambda no exitosa", result);
        }
    }
    @Test
    void handleRequestTestError() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream eventStream = this.getClass().getResourceAsStream("/InputLambdaUpdateError.json");
        RequestHandler<Object, String> handler = new FileProcessing();
        Object object = objectMapper.readValue(eventStream, Object.class);
        String result = withEnvironmentVariable(
                "SECRET_ARN", "arn:aws:secretsmanager:us-east-1:681989517074:secret:/tmp/ATMSrv/database/credentials-fh8oN")
                .and("AWS_REGION", "us-east-1")
                .execute(() -> {
                    String resultado = handler.handleRequest(object, null);
                    return resultado;
                });
        assertEquals("Ejecución de Lambda no exitosa", result);
    }*/
}