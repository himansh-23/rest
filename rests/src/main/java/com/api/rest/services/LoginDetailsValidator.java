package com.api.rest.services;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import com.api.rest.models.LoginDetails;

@Service
public class LoginDetailsValidator implements Validator {

//	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

//	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoginDetails l=(LoginDetails)target;
		//[@]{1}[.]
		System.out.println(errors.getErrorCount());
		if(Pattern.matches("[a-z0-9]{4,}", l.getEmail()))
		{
			System.out.println("valid");	
		}
		else
		{
			System.out.println("Email Invalid");
			errors.reject("field1","Email Format is Not Correct");
		//	errors.rejec
		}
		
		//System.out.println("hello");
	}

}
