package com.cobis.cloud.channelscommons.aws.batch.procesos;

import com.cobis.cloud.infra.api.SqlType;
import com.cobis.cloud.infra.api.dto.Parameter;

import java.util.ArrayList;
import java.util.List;

public class UtilJobDefinition{

    public static List<Parameter> buildParams(String trn, String fechaProceso, String fechaActual, String producto) {

        ArrayList<Parameter> parameters = new ArrayList<>();

        if (trn != null) {
            parameters.add(new Parameter("@t_trn", SqlType.VARCHAR.getValue(), 1, trn));
            parameters.add(new Parameter("@i_fecha1", SqlType.VARCHAR.getValue(), 1, fechaProceso));
            parameters.add(new Parameter("@i_fecha2", SqlType.VARCHAR.getValue(), 1, fechaActual));
        }

        if (producto != null)
        {
            parameters.add(new Parameter("@i_producto", SqlType.VARCHAR.getValue(), 1, producto));
            parameters.add(new Parameter("@i_fecha_proceso", SqlType.VARCHAR.getValue(), 1, fechaProceso));
            parameters.add(new Parameter("@i_fecha_actual",  SqlType.VARCHAR.getValue(), 1, fechaActual));
        }

        return parameters;
    }
}