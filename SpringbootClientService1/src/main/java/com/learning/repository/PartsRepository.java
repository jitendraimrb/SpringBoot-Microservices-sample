package com.learning.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.PartsDetails;

@Repository
public interface PartsRepository extends JpaRepository<PartsDetails, Serializable>{
	
	
	public PartsDetails findByPartsNumber(String partsNumber);

}
