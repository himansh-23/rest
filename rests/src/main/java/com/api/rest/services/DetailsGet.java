package com.api.rest.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.rest.models.UserDetails;

public interface DetailsGet {

	ResponseEntity<UserDetails> detailsById(int id);
	List<UserDetails> detailsAllId();
}
