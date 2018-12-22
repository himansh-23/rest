package com.api.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.rest.models.LoginDetails;
import com.api.rest.models.UserDetails;
import com.api.rest.repository.Database;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	Database database;
	
	public ResponseEntity<UserDetails> authUser(LoginDetails logindetails)
	{
		return database.valid(logindetails);	
	}
	public void register(LoginDetails logindetails) {
		
		String s=logindetails.getPassword();
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		String s1=bcryptEncoder.encode(s);
		logindetails.setPassword(s1);
		database.passwordinsert(logindetails);
		System.out.println("complete");
		
	}

}
