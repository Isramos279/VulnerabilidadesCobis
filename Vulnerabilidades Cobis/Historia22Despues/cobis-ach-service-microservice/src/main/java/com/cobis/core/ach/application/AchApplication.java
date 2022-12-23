/*
 * Copyright (c) 2020 Cobiscorp (Banking Technology Partners) SA, All Rights Reserved.
 *
 * This code is confidential to Cobiscorp and shall not be disclosed outside Cobiscorp
 * without the prior written permission of the Technology Center.
 *
 * In the event that such disclosure is permitted the code shall not be copied
 * or distributed other than on a need-to-know basis and any recipients may be
 * required to sign a confidentiality undertaking in favor of Cobiscorp SA.
 *
 */
package com.cobis.core.ach.application;

import com.cobis.core.ach.achrest.AchServiceAppConfig;
import com.cobis.core.ach.processing.ProcessingAppConfig;
import com.cobis.core.ach.transform.TransformAppConfig;
import com.cobiscorp.ecobis.isoprdservice.bsl.serv.config.PrdMwAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TransformAppConfig.class, ProcessingAppConfig.class, AchServiceAppConfig.class})
@ComponentScan(basePackageClasses = PrdMwAutoConfiguration.class)
public class AchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AchApplication.class, args);
	}
}
