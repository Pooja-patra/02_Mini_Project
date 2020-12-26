package com.example.Entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class City 
{
	Integer cityId;
	String cityName;
	Integer stateId;
}
