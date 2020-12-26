package com.example.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Services.UserService;

@RestController
public class RegistrationRestController
{
	@Autowired
	UserService userservice;

    @GetMapping(value="/getcountry",
    		
    		produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
    		
    		)
   public ResponseEntity<Map<Integer,String>> getCountries()
   {
    	Map<Integer, String> findCountries = userservice.findCountries();
    	
	return new ResponseEntity<>(findCountries,HttpStatus.CREATED);
	   
   }
    
    @GetMapping(value="/getstate{/cid}",
    		
    		produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
    		
    		)
    public ResponseEntity<Map<Integer,String>> getState(@PathVariable("cid") Integer countryId)
    {
    	Map<Integer, String> findStates = userservice.findStates(countryId);
    	
		return new ResponseEntity<>(findStates,HttpStatus.CREATED);
    	
    }
    
    @GetMapping(value="/getcity{/sid}",
    		
    		produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
    		)
    public ResponseEntity<Map<Integer,String>> getCity(@PathVariable("sid") Integer stateId)
    {
    	Map<Integer, String> findCities = userservice.findCities(stateId);
    	
		return new ResponseEntity<>(findCities,HttpStatus.CREATED);
    }
    
    @GetMapping(value="/checkemail{/email}",
    		
    		produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
    		
    		)
    public boolean checkIsEmailUnique(@PathVariable("email") String emailId)
    {
    	boolean emailUnique = userservice.isEmailUnique(emailId);
    	
		return emailUnique;	
    }
    
    @PostMapping(value="/userInfo",
    		
    		produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
    		
    		)
    public boolean SubmitUserForm(@RequestBody User user)
    {
    	boolean saveUser = userservice.saveUser(user);
		return saveUser;
    }
    
	
}
