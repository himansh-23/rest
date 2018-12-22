package com.api.rest.services;

import org.springframework.http.ResponseEntity;

import com.api.rest.models.LoginDetails;
import com.api.rest.models.UserDetails;

public interface LoginService {

	ResponseEntity<UserDetails> authUser(LoginDetails logindetails);
	void register(LoginDetails logindetails);

}
