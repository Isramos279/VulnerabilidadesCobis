package com.cobis.core.ach.microservice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.log4j.Log4j2;
import org.testcontainers.containers.MySQLContainer;

import com.cobis.xsell.commons.bsl.exception.InfrastructureRuntimeException;

@Log4j2
public class ConnectionUtil {

    public static Connection getRootConnection(MySQLContainer mySqlContainer) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new InfrastructureRuntimeException("No se encontro la clase: com.mysql.cj.jdbc.Driver", e);
        }
        log.info("url:" + mySqlContainer.getJdbcUrl());
        return DriverManager.getConnection(mySqlContainer.getJdbcUrl() +"?sessionVariables=sql_mode=PIPES_AS_CONCAT", "root", mySqlContainer.getPassword());
    }

}