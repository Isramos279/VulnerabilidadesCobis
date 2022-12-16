package com.cobis.cloud.atm.aws.batch.procesos.b16402;

import com.cobis.businesslogic.commons.IBusinessLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobDefinitionTest {

	JobDefinition jobDefinition;

	@BeforeEach
	void setUp(){
		//Parámetros para todas las pruebas
		jobDefinition = new JobDefinition();
	}

	@Test
	void testGetBusinessLogicProgram(){
		//Valor esperado
		IBusinessLogic iBusinessLogicExpected = new BL_file_collections();
		IBusinessLogic iBusinessLogic;
		//Ejecución del método
		iBusinessLogic = jobDefinition.getBusinessLogicProgram();
		//Assersiones
		Assertions.assertEquals(iBusinessLogicExpected.getClass(),iBusinessLogic.getClass());
	}
}
