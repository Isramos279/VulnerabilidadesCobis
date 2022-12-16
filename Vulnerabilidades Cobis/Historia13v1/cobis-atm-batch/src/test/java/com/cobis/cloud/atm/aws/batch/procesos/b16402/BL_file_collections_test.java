package com.cobis.cloud.atm.aws.batch.procesos.b16402;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BL_file_collections_test {

    BL_file_collections bl_file_collections;

    @BeforeEach
    void setUp(){
        //Parámetros para todas las pruebas
        bl_file_collections = new BL_file_collections();
    }

    @Test
    void testExecuteDetailValidations() throws Exception {
        //Assersiones
        Assertions.assertNull(bl_file_collections.executeDetailValidations());
    }

    @Test
    void testExecuteHeaderValidations() throws Exception {
        //Assersiones
        Assertions.assertNull(bl_file_collections.executeHeaderValidations(null));
    }
}