package com.cobis.cloud.atm.aws.batch.procesos;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.batch.IJobDefinition;
import com.cobis.cloud.infra.api.SqlType;
import com.cobis.cloud.infra.api.dto.Parameter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class UtilJobDefinition implements IJobDefinition<RequestObject> {

    @Override
    public List<Parameter> buildParams(RequestObject requestObject) {
        log.debug("Inica ejecución de job: " + System.getenv("JOB_ID"));
        ArrayList<Parameter> parameters = new ArrayList<>();
        if (requestObject.getFechaProceso() != null) {
            parameters.add(new Parameter("@i_fecha_proceso", SqlType.VARCHAR.getValue(), 1, requestObject.getFechaProceso()));
        }
        if (requestObject.getOperacion() != null) {
            parameters.add(new Parameter("@i_operacion", SqlType.CHAR.getValue(), 1, requestObject.getOperacion()));
        }
        if (requestObject.getFechaInicio() != null) {
            parameters.add(new Parameter("@i_fecha_i", SqlType.DATETIME.getValue(), 1, requestObject.getFechaInicio()));
        }
        if (requestObject.getFechaFin() != null) {
            parameters.add(new Parameter("@i_fecha_f", SqlType.DATETIME.getValue(), 1, requestObject.getFechaFin()));
        }
        if (requestObject.getiProducto() != null) {
            parameters.add(new Parameter("@i_producto", SqlType.INT.getValue(), 1, requestObject.getiProducto()));
        }
        return parameters;
    }

    @Override
    public IBusinessLogic getBusinessLogicProgram() {
        return null;
    }

    @Override
    public Class<RequestObject> getRequestObjectClass() {
        return RequestObject.class;
    }
}