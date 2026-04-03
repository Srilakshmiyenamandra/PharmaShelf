package com.microservices.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingApplication.class, args);
	}


@Bean
@LoadBalanced
public RestTemplate getRestTemplate()
{
	return new RestTemplate();
}
}