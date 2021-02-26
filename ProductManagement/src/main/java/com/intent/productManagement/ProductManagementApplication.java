package com.intent.productManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;



@SpringBootApplication
@EnableEurekaClient
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		
		//to set timeout at restTemplate level we have create an instance of 		HttpComponentsClientHttpRequestFactory
		
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(3000);
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}

}
