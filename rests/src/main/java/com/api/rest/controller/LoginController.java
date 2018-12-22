package com.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.LoginDetails;
import com.api.rest.models.UserDetails;
import com.api.rest.services.LoginService;

@RestController
@ControllerAdvice
@RequestMapping("/user/login")
public class LoginController {

	@Autowired
	LoginService loginservice;
	@Autowired
	Validator validator;
	
	@PostMapping
		public ResponseEntity<UserDetails> loginValidatate(@RequestBody LoginDetails logindetails, BindingResult bindingresult)
		{
		System.out.println("coming");
			validator.validate(logindetails, bindingresult);
			if(bindingresult.hasErrors())
			{
				throw new NullPointerException();
			}
	//		bindingresult.get
			return loginservice.authUser(logindetails);	
		}
	/*@GetMapping("/user")
	public ResponseEntity<UserDetails> getByUserName(@RequestParam String userName) {
		System.out.println(userName);
		return new ResponseEntity<>(new UserDetails(), HttpStatus.ACCEPTED);
	}*/
		/*@ExceptionHandler(value = NullPointerException.class)
		public String exceptionHandler(Exception e)
		{
			return "Email Is not Found";
		}*/
	/*@GetMapping
	public String getUsers() {
		return null;
		
	}
	@GetMapping("/query")
	public String getUserByTokenAndId() {
		
	}
	@GetMapping("{ids}")
	public String getUserById(@PathVariable(value="ids")int id) {
		return null;
		
	}*/
		
		@PostMapping("/datainsert")
		public void dataInsert(@RequestBody LoginDetails logindetails)
		{
			loginservice.register(logindetails);	
		}
	
}
