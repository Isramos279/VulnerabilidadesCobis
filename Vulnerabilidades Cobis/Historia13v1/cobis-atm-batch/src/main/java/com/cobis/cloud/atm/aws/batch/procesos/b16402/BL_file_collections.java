package com.cobis.cloud.atm.aws.batch.procesos.b16402;


import com.cobis.cloud.fileprocessing.api.dto.FileProcessingHeader;
import com.cobis.cloud.fileprocessing.api.dto.FileProcessingHeaderValidationResult;
import com.cobis.cloud.fileprocessing.api.dto.FileProcessingValidationErrorResult;
import com.cobiscorp.businesslogic.commons.BusinessLogicFileProcessingBase;

import java.util.List;

public class BL_file_collections extends BusinessLogicFileProcessingBase {

    @Override
    public FileProcessingValidationErrorResult executeDetailValidations() throws Exception {
        return null;
    }

    @Override
    public FileProcessingHeaderValidationResult executeHeaderValidations(List<FileProcessingHeader> list) {
       return null;
    }

}