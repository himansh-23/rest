package com.api.rest.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.api.rest.models.LoginDetails;
import com.api.rest.models.UserDetails;

@Repository
public class Database {

	Connection connection;
	Statement statement;
	public Database()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "admin", "admin123");
		statement=connection.createStatement();
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ResponseEntity<UserDetails> valid(LoginDetails logindetails)
	{
		String sql="select * from db where email='"+logindetails.getEmail()+
		
				"' and password='"+logindetails.getPassword()+"'";
		ResultSet rst;
		UserDetails u=new UserDetails();
		try {
			rst=statement.executeQuery(sql);
			if(rst.next())
			{
				u.setId(rst.getInt(1));
				u.setUsername(rst.getString(2));
				u.setPassword(rst.getString(3));
				u.setFirstname(rst.getString(4));
				u.setLastname(rst.getString(5));
				u.setEmail(rst.getString(6));
				u.setPhone(rst.getString(7));
				return new ResponseEntity<UserDetails>(u, HttpStatus.OK);	
			}
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
					
		return new ResponseEntity<UserDetails>(u,HttpStatus.NOT_FOUND);
		
	}
	
	public ResponseEntity<UserDetails> getIdDetails(int id)
	{
		String sql="select * from db where id="+id;
		ResultSet rst;
		UserDetails u=new UserDetails();
		try{
			rst=statement.executeQuery(sql);
			if(rst.next())
			{
				u.setId(rst.getInt(1));
				u.setUsername(rst.getString(2));
				u.setPassword(rst.getString(3));
				u.setFirstname(rst.getString(4));
				u.setLastname(rst.getString(5));
				u.setEmail(rst.getString(6));
				u.setPhone(rst.getString(7));
				return new ResponseEntity<UserDetails>(u,HttpStatus.OK);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			return new ResponseEntity<UserDetails>(u,HttpStatus.NOT_FOUND);
		}
	
	public List<UserDetails> getAllDetails()
	{
		String sql="select * from db";
		ResultSet rst;
		
		List<UserDetails> list=new ArrayList<UserDetails>();
		try{
			rst=statement.executeQuery(sql);
			while(rst.next())
			{
				UserDetails u=new UserDetails();
				u.setId(rst.getInt(1));
				u.setUsername(rst.getString(2));
				u.setPassword(rst.getString(3));
				u.setFirstname(rst.getString(4));
				u.setLastname(rst.getString(5));
				u.setEmail(rst.getString(6));
				u.setPhone(rst.getString(7));
				list.add(u);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void passwordinsert(LoginDetails logindetails)
	{
		String sql="insert into db2(user,pass) values('"+
				logindetails.getEmail()+"','"+logindetails.getPassword()+"')";
				try {
					statement.executeUpdate(sql);
					statement.close();
				connection.close();
				
				System.out.println("done");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	}
}
