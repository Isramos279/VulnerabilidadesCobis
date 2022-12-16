package com.cobis.cloud.channelscommons.aws.batch.procesos.b18102;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.channelscommons.aws.batch.procesos.RequestObject;
import com.cobis.cloud.infra.api.dto.Parameter;
import com.cobiscorp.businesslogic.channels.BL_conta_ch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class JobDefinitionTest {

    JobDefinition jobDefinition;

    @BeforeEach
    void setUp(){
        //Parámetros para todas las pruebas
        jobDefinition = new JobDefinition();
    }
    @Test
    void testBuildParams(){

        //Parámetros únicos para esta prueba en particular
        ArrayList<Parameter> parameters;
        RequestObject requestObject = new RequestObject();
        requestObject.setProducto("16");
        requestObject.setFechaActual("2022-02-24");
        requestObject.setFechaProceso("2021-04-30");

        //Ejecución del método
        parameters = (ArrayList<Parameter>) jobDefinition.buildParams(requestObject);

        //Assersiones
        Assertions.assertEquals("16",parameters.get(0).getValue());
    }

    @Test
    void testGetBusinessLogicProgram(){

        //Valor esperado
        IBusinessLogic iBusinessLogicExpected =new BL_conta_ch();
        IBusinessLogic iBusinessLogic;

        //Ejecución del método
        iBusinessLogic = jobDefinition.getBusinessLogicProgram();

        //Assersiones
        Assertions.assertEquals(iBusinessLogicExpected.getClass(),iBusinessLogic.getClass());
    }

    @Test
    void testGetRequestObjectClass(){

        //Valor esperado
        RequestObject requestObjectOneExpected = new RequestObject();;
        Class<RequestObject> requestObjectOneClass;

        //Ejecución del método
        requestObjectOneClass = jobDefinition.getRequestObjectClass();

        //Assersiones
        Assertions.assertEquals(requestObjectOneExpected.getClass(),requestObjectOneClass);
    }
}
