package com.api.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.rest.models.UserDetails;
import com.api.rest.repository.Database;

@Service
public class DetailsGetImpl implements DetailsGet
{
    @Autowired
    Database database;

   public ResponseEntity<UserDetails> detailsById(int id)
    {
        return database.getIdDetails(id);
    }

    public List<UserDetails> detailsAllId(){

        return database.getAllDetails();
    }

}