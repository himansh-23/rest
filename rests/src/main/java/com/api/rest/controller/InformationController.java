package com.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.AllUsers;
import com.api.rest.models.UserDetails;
import com.api.rest.services.DetailsGet;

@RestController
public class InformationController {
	
	@Autowired
	DetailsGet detailsget;
	
	@GetMapping("/getiddata")
    public ResponseEntity<UserDetails> userById(@RequestParam int id)
    {
        return detailsget.detailsById(id);
    }
	
	@GetMapping("/getalldata")
    public ResponseEntity<AllUsers> userAllId()
    {
		AllUsers allusers=new AllUsers();	
		allusers.setList(detailsget.detailsAllId());
		return new ResponseEntity<AllUsers>(allusers,HttpStatus.OK);	 
    }

}

//.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps
