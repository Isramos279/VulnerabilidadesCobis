package com.cobis.cloud.atm.aws.batch.procesos.b16201;


import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.atm.aws.batch.procesos.RequestObject;
import com.cobis.cloud.infra.api.dto.Parameter;
import com.cobiscorp.businesslogic.atm_his.BL_atm_paso_his_tranmonet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
		List<Parameter> parameters;
		RequestObject requestObject = new RequestObject();

		//Ejecución del método
		parameters =  jobDefinition.buildParams(requestObject);
		requestObject.setFechaProceso("2021-04-30");

		//Assersiones
		Assertions.assertEquals(0,parameters.size());
	}

	@Test
	void testGetBusinessLogicProgram(){

		//Valor esperado
		IBusinessLogic iBusinessLogicExpected = new BL_atm_paso_his_tranmonet();
		IBusinessLogic iBusinessLogic;

		//Ejecución del método
		iBusinessLogic = jobDefinition.getBusinessLogicProgram();

		//Assersiones
		Assertions.assertEquals(iBusinessLogicExpected.getClass(),iBusinessLogic.getClass());
	}

	@Test
	void testGetRequestObjectClass(){

		//Valor esperado
		RequestObject objectOneExpected = new RequestObject();;
		Class<RequestObject> requestObjectOneClass;

		//Ejecución del método
		requestObjectOneClass = jobDefinition.getRequestObjectClass();

		//Assersiones
		Assertions.assertEquals(objectOneExpected.getClass(),requestObjectOneClass);
	}
}
