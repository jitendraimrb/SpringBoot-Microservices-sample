package com.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/parts/management/v1")
@Slf4j
public class PartsOrderController {
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
//	@Value("${microservice.client1-service.endpoints.endpoint.uri}")
//	private String END_POINT;
	
	@GetMapping("/validateOrder")
	public List<String> invokeClient1ServiceForGettingOrderList() {
		
		String service1_url = "http://PARTS-ORDER-CLIENT-APP/parts/order/v1/getPartsOrderList";
		log.info("Inside the Client-2 Service... ");
		return restTemplate.getForObject(service1_url, ArrayList.class);
	}
	
	@GetMapping("/validateOrder/{orderName}")
	public Optional<String> invokeClient1ServiceForGettingOrderByOrderName(@PathVariable String orderName) {
		
		String service1_url = "http://PARTS-ORDER-CLIENT-APP/parts/order/v1/getPartsOrderList";
		log.info("Inside the Client-2 Service... ");
		return restTemplate.getForObject(service1_url, ArrayList.class).stream().filter(s->s.equals(orderName)).findFirst();
	}

}
