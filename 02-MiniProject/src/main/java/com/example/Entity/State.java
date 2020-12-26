package com.example.Entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class State 
{
	Integer stateId;
	String stateName;
	Integer countryId;
	
	
}
