package com.cobis.cloud.atm.aws.batch.procesos.b16405;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.atm.aws.batch.procesos.RequestObject;
import com.cobis.cloud.infra.api.dto.Parameter;
import com.cobiscorp.businesslogic.atm.BL_pagos_comercios_tc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class JobDefinitionTest {

	com.cobis.cloud.atm.aws.batch.procesos.b16405.JobDefinition jobDefinition;

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
		//Assersiones
		Assertions.assertEquals(0, parameters.size());
	}

	@Test
	void testGetBusinessLogicProgram(){
		//Valor esperado
		IBusinessLogic iBusinessLogicExpected = new BL_pagos_comercios_tc();
		IBusinessLogic iBusinessLogic;
		//Ejecución del método
		iBusinessLogic = jobDefinition.getBusinessLogicProgram();
		//Assersiones
		Assertions.assertEquals(iBusinessLogicExpected.getClass(),iBusinessLogic.getClass());
	}

	@Test
	void testGetRequestObjectClass(){
		//Valor esperado
		RequestObject objectOneExpected = new RequestObject();
		//Ejecución del método
		Class<RequestObject> requestObjectOneClass = jobDefinition.getRequestObjectClass();
		//Assersiones
		Assertions.assertEquals(objectOneExpected.getClass(),requestObjectOneClass);
	}
}
