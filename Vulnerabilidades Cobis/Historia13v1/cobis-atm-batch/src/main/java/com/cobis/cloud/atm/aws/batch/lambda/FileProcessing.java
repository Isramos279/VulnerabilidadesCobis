package com.cobis.cloud.atm.aws.batch.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cobis.businesslogic.commons.Parameter;
import com.cobis.businesslogic.commons.Variable;
import com.cobis.cloud.atm.aws.batch.utils.UtilsSecretManager;
import com.cobis.cloud.atm.aws.batch.entities.DataBaseCredentials;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.BasicConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import static com.cobis.businesslogic.commons.enums.VariableDataType.INTEGER;

@Log4j2
public class FileProcessing implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context)  {

        log.info("CSO Objeto de entrada: " + input.toString());
        log.info("Variables de entorno: " + System.getenv());

        /*
        BasicConfigurator.configure();
        log.info("Se inicia ejecución de la lambda para actualizar el estado");

        try {
            String[] ruta       = {"response","payload","Input","atmFileUpdate"};
            String secretArn    = System.getenv("SECRET_ARN");
            String secretRegion = System.getenv("AWS_REGION");
            String status       = (String) ((Map) ((Map) input).get("response")).get("status");
            String mensaje      = (!status.equals("SUCCESS")) ? "Error en la carga del archivo, revise StepFunction de AWS" : "";
            String nameFile;
            String intento;
            String resultado;

            if (status.equals("SUCCESS")) {
                nameFile =  (String) ((Map) ((Map) ((Map) ((Map) ((Map) input).get(ruta[0])).get(ruta[1])).get(ruta[2])).get(ruta[3])).get("nameFile");
                intento =   (String) ((Map) ((Map) ((Map) ((Map) ((Map) input).get(ruta[0])).get(ruta[1])).get(ruta[2])).get(ruta[3])).get("intentoCarga");
                resultado = "OK";
            } else {
                nameFile =  (String) ((Map) ((Map) ((Map) ((Map) input).get(ruta[0])).get(ruta[1])).get(ruta[3])).get("nameFile");
                intento =   (String) ((Map) ((Map) ((Map) ((Map) input).get(ruta[0])).get(ruta[1])).get(ruta[3])).get("intentoCarga");
                resultado = "Error";
            }

            Gson gson = new Gson();
            String secretValue = UtilsSecretManager.getSecret(secretArn, secretRegion);
            DataBaseCredentials credentials = gson.fromJson(secretValue, DataBaseCredentials.class);

            String jdbcConnection = String.format("jdbc:mysql://%s:%s/%s?%s", credentials.getMasterEndpoint(),  credentials.getMasterPort(), credentials.getDatabase(), credentials.getPassword());

            try(Connection connection  = DriverManager.getConnection(jdbcConnection, credentials.getUsername(), credentials.getPassword())) {

                com.cobis.businesslogic.commons.Context contextLocal = new com.cobis.businesslogic.commons.Context(connection);
                Variable wIntento = new Variable("@w_intento", INTEGER);

                int returnCode = contextLocal.exec("com.cobiscorp.businesslogic.atm_cp.BL_manten_recepcion",
                        new Parameter("@t_trn", "16987"),
                        new Parameter("@i_nombre_archivo", nameFile),
                        new Parameter("@i_paso", "4"),
                        new Parameter("@i_resultado", resultado),
                        new Parameter("@i_intento", intento),
                        new Parameter("@i_mensaje", mensaje),
                        new Parameter("@i_operacion", "U"),
                        new Parameter("@o_intento out", wIntento)
                );

                log.info("Ejecución de BL_manten_recepcion: " + returnCode);

                return "Ejecución de Lambda exitosa";
            }
        } catch (Exception e) {
            log.error("Excepción en actualizar el estado de la lambda" , e);
            return "Ejecución de Lambda no exitosa";
        }
        */
        return "Ejecución de Lambda exitosa";
    }
}