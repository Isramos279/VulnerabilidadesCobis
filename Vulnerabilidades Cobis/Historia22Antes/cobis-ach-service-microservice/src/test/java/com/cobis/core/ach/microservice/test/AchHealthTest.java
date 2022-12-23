package com.cobis.core.ach.microservice.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.cobis.infra.test.security.aws.config.CognitoProperties;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"achrest"})
@ContextConfiguration(initializers = AbstractContainerBaseTest.Initializer.class)
@ComponentScan(basePackages = { "com.cobis.core.ach",
        "com.cobis.xsell.infra.microservice.exception",
        "com.cobis.xsell.commons.pseudocatalog", "com.cobis.infra.test.security" })
@ConfigurationPropertiesScan(basePackageClasses = { CognitoProperties.class })
class AchHealthTest /*extends AbstractContainerBaseTest */{

    /*@Disabled("Desabilitado hasta que se resuelva el tema de usar las carpetas liquibase")
    @Test
    void testHealthCheckIsOmmited() throws Exception {
        ResponseEntity<String> response = restTemplate.
                getForEntity(getBaseUrl() + "/cobis/core/ach/actuator/health/", String.class);

        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
    }

    @Disabled("Desabilitado hasta que se resuelva el tema de usar las carpetas liquibase")
    @Test
    void testNotFound() {
        ResponseEntity<String> response = restTemplate.
                getForEntity(getBaseUrl() + "/cobis/core/ach/orders/1201220", String.class);

        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.NOT_FOUND)));
    }*/

}
