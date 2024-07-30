package com.gokulr488.spring.discovery_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class DiscoveryGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryGatewayApplication.class, args);
	}

}
