package com.cobis.cloud.channelscommons.aws.batch.procesos.b18102;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.batch.IJobDefinition;
import com.cobis.cloud.channelscommons.aws.batch.procesos.RequestObject;
import com.cobis.cloud.channelscommons.aws.batch.procesos.UtilJobDefinition;
import com.cobis.cloud.infra.api.dto.Parameter;
import com.cobiscorp.businesslogic.channels.BL_conta_ch;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class JobDefinition implements IJobDefinition<RequestObject> {

	public List<Parameter> buildParams(RequestObject requestObject) {
		return UtilJobDefinition.buildParams(requestObject.getTrn(), requestObject.getFechaProceso(), requestObject.getFechaActual(), requestObject.getProducto());
	}

	@Override
	public IBusinessLogic getBusinessLogicProgram() {
		return new BL_conta_ch();
	}

	@Override
	public Class<RequestObject> getRequestObjectClass() {
		return RequestObject.class;
	}
}
