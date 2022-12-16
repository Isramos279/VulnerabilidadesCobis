package com.cobis.cloud.atm.aws.batch.procesos.b16301;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.atm.aws.batch.procesos.RequestObject;
import com.cobis.cloud.batch.IJobDefinition;
import com.cobis.cloud.infra.api.SqlType;
import com.cobis.cloud.infra.api.dto.Parameter;
import com.cobiscorp.businesslogic.atm.BL_consolidador_atm;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class JobDefinition implements IJobDefinition<RequestObject> {

	@Override
	public List<Parameter> buildParams(RequestObject requestObject) {
		List<Parameter> parameters = new ArrayList<>();
		log.debug("Inicia ejecución de proceso 16301");
		parameters.add(new Parameter("@i_fecha_proceso", SqlType.VARCHAR.getValue(), 1, requestObject.getFechaProceso()));
		return parameters;
	}

	@Override
	public IBusinessLogic getBusinessLogicProgram() {
		return new BL_consolidador_atm();
	}

	@Override
	public Class<RequestObject> getRequestObjectClass() {
		return RequestObject.class;
	}
}