package com.cobis.core.ach.microservice.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MySQLContainer;

import com.cobis.infra.security.exception.AuthorizationInvalidFormatException;
import com.cobis.infra.security.jwt.JWTService;
import com.cobis.infra.test.security.dto.LoginResponse;
import com.cobis.xsell.commons.bsl.exception.AuthorizationNotFoundException;

public abstract class AbstractContainerBaseTest {
    protected static final MySQLContainer MY_SQL_CONTAINER;
    private Map<String, Object> claims = null;

    @LocalServerPort
    private int port;

    @MockBean
    protected JWTService jwtService;

    @Autowired
    protected WebTestClient webTestClient;

    @Autowired
    protected TestRestTemplate restTemplate;

    static {
        MY_SQL_CONTAINER = BDDContainer.getContainer();
        MY_SQL_CONTAINER.start();
        Connection rootConnection;
        try {
            rootConnection = ConnectionUtil.getRootConnection(MY_SQL_CONTAINER);
            //setUpAdminCobisData(rootConnection);
            //setUpAdminCobisTestData(rootConnection);
            //} catch (LiquibaseException | SQLException e) {
        } catch (SQLException e) {
            throw new RuntimeException("Test database exception", e);
        }
    }

    /*protected LoginResponse getLoginResponse() {
        claims = new HashMap<>();
        claims.put("rol", "3");
        try {
            Mockito.when(jwtService.validateToken(ArgumentMatchers.any(HttpServletRequest.class))).thenReturn(claims);
        } catch (AuthorizationInvalidFormatException | AuthorizationNotFoundException e) {
        }
        LoginResponse loginResponse= new LoginResponse();
        loginResponse.setWebToken("fake-token");
        return loginResponse;
    }*/

//    private static void setUpAdminCobisData(Connection connection) throws LiquibaseException {
//        File folderLog = new File("../liquibase/cobis");
//        if(!folderLog.exists()) {
//            throw new RuntimeException("FolderLog for liquibase doesn't exists:" + folderLog.getAbsolutePath());
//        }
//        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
//        database.setDatabaseChangeLogLockTableName("cobis_adm_change_log_lock");
//        database.setDatabaseChangeLogTableName("cobis_adm_change_log");
//        database.setDefaultSchemaName("cobis");
//        Liquibase liquibase = new liquibase.Liquibase(
//                "cobis-master.xml",
//                new FileSystemResourceAccessor(folderLog), database);
//        liquibase.update(new Contexts(), new LabelExpression());
//    }

    //    private static void setUpAdminCobisTestData(Connection connection) throws LiquibaseException {
//        File folderLog = new File("../liquibase-test/cobis");
//        if(!folderLog.exists()) {
//            throw new RuntimeException("FolderLog for liquibase doesn't exists:" + folderLog.getAbsolutePath());
//        }
//        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
//        database.setDatabaseChangeLogLockTableName("cobis_adm_test_change_log_lock");
//        database.setDatabaseChangeLogTableName("cobis_adm_test_change_log");
//        database.setDefaultSchemaName("cobis");
//        Liquibase liquibase = new liquibase.Liquibase(
//                "cobis-master.xml",
//                new FileSystemResourceAccessor(folderLog), database);
//        liquibase.update(new Contexts(), new LabelExpression());
//    }
    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues values = TestPropertyValuesUtil.getTestPropertyValues(MY_SQL_CONTAINER);
            values.applyTo(configurableApplicationContext);
        }
    }

    protected String getBaseUrl() {
        return "http://localhost:" + port ;
    }

}
