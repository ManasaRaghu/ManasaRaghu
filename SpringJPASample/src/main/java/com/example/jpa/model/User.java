package com.example.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class User {
	@Id  
	private int id;  
	private String username;  
	
	public int getId()   
	{  
	return id;  
	}  
	public void setId(int id)   
	{  
	this.id = id;  
	}  
	public String getUname()   
	{  
	return username;  
	}  
	public void setUname(String username)   
	{  
	this.username = username;  
	}  

}
