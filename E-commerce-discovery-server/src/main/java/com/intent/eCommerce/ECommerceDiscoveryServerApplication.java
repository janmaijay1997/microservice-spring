package com.intent.eCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ECommerceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceDiscoveryServerApplication.class, args);
	}

}
