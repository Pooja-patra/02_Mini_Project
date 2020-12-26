package com.example.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.UserService;

@RestController
public class UnlockAccountRestController 
{
	@Autowired
	UserService userservice;
	
	
	@GetMapping(value="/pwdvalidation{/email}",
			
			
			produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
			)
	public boolean passwordvalidation(@PathVariable("email")String emailId,String pwd)
	{
	   boolean tempPwdValid = userservice.isTempPwdValid(emailId, pwd);	
	   
		return tempPwdValid;	
	}
	
	@GetMapping(value="/unlock{/email}",
			produces= {MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_JSON_VALUE}
			)
	public boolean AccountUnlock(@PathVariable("email") String email,String newPwd)
	{
		boolean unlockAccount = userservice.unlockAccount(email, newPwd);
	
		return unlockAccount;
	}
	

}
