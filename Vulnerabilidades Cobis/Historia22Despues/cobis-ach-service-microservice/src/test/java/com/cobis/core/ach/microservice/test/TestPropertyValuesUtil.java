package com.cobis.core.ach.microservice.test;

import org.springframework.boot.test.util.TestPropertyValues;
import org.testcontainers.containers.MySQLContainer;

public class TestPropertyValuesUtil {
    public static TestPropertyValues getTestPropertyValues(MySQLContainer mySQLContainer) {
        return TestPropertyValues.of(
                "spring.datasource.url=" + mySQLContainer.getJdbcUrl() + "?createDatabaseIfNotExist=true",
                "spring.datasource.password=" + mySQLContainer.getPassword(),
                "spring.datasource.username=root"
                //"spring.datasource.username=" + mySQLContainer.getUsername()
        );
    }
}
