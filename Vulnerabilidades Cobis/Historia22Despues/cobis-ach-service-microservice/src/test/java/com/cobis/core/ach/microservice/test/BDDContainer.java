package com.cobis.core.ach.microservice.test;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

public class BDDContainer {
    public static MySQLContainer getContainer(){
        return new MySQLContainer(
                DockerImageName.parse("125277160564.dkr.ecr.us-east-1.amazonaws.com/cobis/devops/mysql:latest"
                ).asCompatibleSubstituteFor("mysql:5.7"))
                .withPassword("rootpw")
                .withUsername("root")
                .withDatabaseName("cobis");
    }
}
