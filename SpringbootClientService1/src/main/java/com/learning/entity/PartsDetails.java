package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PARTS_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartsDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long partsID;
	private String partsNumber;
	private String partsName;
	private String partsDescription;

}
