package com.cobis.cloud.atm.aws.batch.entities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class DataBaseCredentialesTest {

    @Test
    void constructorTest(){
        DataBaseCredentials credentials = new DataBaseCredentials("","","","","","","","","");
        assertNotNull(credentials);
    }

    @Test
    void usernameTest(){
        DataBaseCredentials credentials = new DataBaseCredentials("username","password","engine","database","arguments","endpoint","port","replica","port");
        assertEquals("username",    credentials.getUsername());
        assertEquals("password",    credentials.getPassword());
        assertEquals("engine",      credentials.getEngine());
        assertEquals("database",    credentials.getDatabase());
        assertEquals("arguments",   credentials.getArguments());
        assertEquals("endpoint",    credentials.getMasterEndpoint());
        assertEquals("port",        credentials.getMasterPort());
        assertEquals("replica",     credentials.getReadReplicaEndpoint());
        assertEquals("port",        credentials.getReadReplicaPort());
    }
}