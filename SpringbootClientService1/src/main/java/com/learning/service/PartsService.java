package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.PartsDetails;
import com.learning.repository.PartsRepository;

@Service
public class PartsService {
	
	@Autowired
	PartsRepository partsRepository;

	
	public List<PartsDetails> getPartsDetails(){
		
		return partsRepository.findAll();
	}
	public PartsDetails getPartsDetails(String partNumber){
		
		return partsRepository.findByPartsNumber(partNumber);
	}
	
	public PartsDetails addPartsDetails(PartsDetails partsDetails) {
		return partsRepository.save(partsDetails);
	}
}
