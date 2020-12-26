package com.example.Entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Country 
{
	Integer countryId;
	String countryName;

}
