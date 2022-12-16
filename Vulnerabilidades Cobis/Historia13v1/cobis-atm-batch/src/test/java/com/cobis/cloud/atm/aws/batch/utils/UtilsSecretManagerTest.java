package com.cobis.cloud.atm.aws.batch.utils;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class UtilsSecretManagerTest {

    @Test
    void UtilsSecretManagerTest(){
        try {
            UtilsSecretManager utilsSecretManager = new UtilsSecretManager();
        } catch (IllegalStateException illegalStateException){
            assertTrue(true);
            return;
        }
        assertTrue(false);
    }
}
