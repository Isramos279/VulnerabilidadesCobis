package com.cobis.cloud.atm.aws.batch.procesos.b16406;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.atm.aws.batch.procesos.UtilJobDefinition;
import com.cobiscorp.businesslogic.atm_his.BL_atm_paso_his_logtran;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JobDefinition extends UtilJobDefinition {

	@Override
	public IBusinessLogic getBusinessLogicProgram() {
		return new BL_atm_paso_his_logtran();
	}

}