package com.learning.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.PartsDetails;
import com.learning.service.PartsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/parts/order/v1")
@Slf4j
public class OrderController {
	
	@Autowired
	PartsService partsService;
	
	@GetMapping("/getPartsOrderList")
	public List<String> getOrderList(){
		log.info("inside the Client-1 Service");
		return new ArrayList<>(Arrays.asList("Laptop","Desktop","Mouse"));
	}
	
	@GetMapping(value = "/getPartsDetails")
	public List<PartsDetails> getPartsDetails(){
		
		return partsService.getPartsDetails();
	}
	
	@GetMapping(value = "/getPartsDetails/{partNumber}")
	public PartsDetails getPartsDetailsByPartsNo(@PathVariable String partNumber){
		
		return partsService.getPartsDetails(partNumber);
	}
	
	@PostMapping(value = "/addPartsDetail")
	public PartsDetails addPartsDetail(@RequestBody PartsDetails partsDetails) {
		
		return partsService.addPartsDetails(partsDetails);
		
	}

}
