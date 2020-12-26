package com.example.Entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class User 
{
	Integer userId;
	String fName;
	String lName;
	String eMail;
	String phNo;
	String dob;
	Integer countryId;
	Integer stateId;
	Integer cityId;
	String  pwd;
	String Acc_Status;
}
