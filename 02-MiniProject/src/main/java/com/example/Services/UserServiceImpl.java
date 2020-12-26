package com.example.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entity.City;
import com.example.Entity.Country;
import com.example.Entity.State;
import com.example.Entity.User;
import com.example.Repository.CityRepository;
import com.example.Repository.CountryRepository;
import com.example.Repository.StateRepository;
import com.example.Repository.UserRepository;

public class UserServiceImpl implements UserService 
{
	@Autowired
	UserRepository userRepo;
	
	@Autowired
    CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	

	@Override
	public Map<Integer, String> findCountries() 
	{
		List<Country> countrieslist =countryRepo.findAll();

		Map<Integer, String> countriesmap = new HashMap<Integer, String>();

		countrieslist.forEach(country -> {

			countriesmap.put(country.getCountryId(), country.getCountryName());

		});

		return countriesmap;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId)
	{
		List<State> statelist=stateRepo.findBycountryId(countryId);
		
		Map<Integer,String> statemap=new HashMap<>();
		
		statelist.forEach(states->{
			statemap.put(states.getStateId(),states.getStateName());
		});
       
		return statemap;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) 
	{
		List<City> citieslist=cityRepo.findBystateId(stateId);
		
		Map<Integer,String> citiesmap=new HashMap<>();
		
		citieslist.forEach(city->
		{
			citiesmap.put(city.getCityId(),city.getCityName());
			
		});
		return citiesmap;
	}

	@Override
	public boolean isEmailUnique(String emailId)
	{
		User userInfo=userRepo.findByeMail(emailId);
		
		return userInfo.getUserId()==null;
	}

	@Override
	public boolean saveUser(User user) 
	{
		user.setPwd(passwordGenerator());
		User userObj=userRepo.save(user);
		return userObj.getUserId()!=null;
	}
	
	public String passwordGenerator()
	{
	  char[]  password=new char[5];
	  String alphaNumeric="ABVXNJMSR123asdfg";
	  Random randompwd=new Random();

	  for(int i=0;i<5; i++)
	{
	    password[i]=alphaNumeric.charAt(randompwd.nextInt(alphaNumeric.length()));
	 
	}
	return password.toString();
	}

	
	//if email and pwd is invalid=Invalid Credencial
	//if email and pwd is valid and locked=your Account is locked
	//if email and pwd is valid and unlocked=Login Success
	@Override
	public String loginCheck(String email, String pwd)
	{
		User UserObj = userRepo.findeMailAndpwd(email, pwd);
		
		if(UserObj!=null)
		{
			if(UserObj.getAcc_Status().equals("LOCKED"))
			{
				return "Your Account is LOCKED";
			}else {
				return "Login Scuccess";
			}
		}
		return "Invalid Credential";
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) 
	{
		User UserObj=userRepo.findeMailAndpwd(email, tempPwd);
		if(UserObj.getEMail()==email && UserObj.getPwd()==tempPwd)
		{
		   return true;
		}
		
		return false;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) 
	{
		User UserObj=userRepo.findByeMail(email);
		UserObj.setPwd(newPwd);
		UserObj.setAcc_Status("UNLOCKED");
		userRepo.save(UserObj);
  		return true;
	}

	@Override
	public String forgotPassword(String email) 
	{
		User UserObj=userRepo.findByeMail(email);

  		return UserObj.getPwd();
	}

}
