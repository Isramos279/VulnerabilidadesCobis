
package com.cobis.cloud.atm.aws.batch.procesos.b16402;

import com.cobis.businesslogic.commons.IBusinessLogic;
import com.cobis.cloud.fileprocessing.batch.FileProcessingJobDefinitionBase;
import com.cobis.cloud.infra.api.log.ILogger;
import com.cobis.cloud.infra.impl.log.LogFactory;

public class JobDefinition extends FileProcessingJobDefinitionBase {

	private static final ILogger logger = LogFactory.getLogger(JobDefinition.class);

	@Override
	public IBusinessLogic getBusinessLogicProgram() {
		logger.logDebug(System.getenv("JOB_ID") + ":getBusinessLoginProgram called");
		return new BL_file_collections();
	}
}
