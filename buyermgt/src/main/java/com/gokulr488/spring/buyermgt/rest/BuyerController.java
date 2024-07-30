package com.gokulr488.spring.buyermgt.rest;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class BuyerController {

	private final DiscoveryClient discoveryClient;
	private final RestClient restClient;

	public BuyerController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
		this.discoveryClient = discoveryClient;
		restClient = restClientBuilder.build();
	}

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world from Buyer Mgt";
	}

	@GetMapping("helloEureka")
	public String helloEureka() {
		ServiceInstance serviceInstance = discoveryClient.getInstances("servicea").get(0);
		String serviceAResponse = restClient.get()
				.uri(serviceInstance.getUri() + "/helloWorld")
				.retrieve()
				.body(String.class);
		return serviceAResponse;
	}
}