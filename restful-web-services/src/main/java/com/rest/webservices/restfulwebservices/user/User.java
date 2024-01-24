package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class User {

	@Id
	 private Integer id ;
	@Size(min = 2 ,message = "name should have  minumum 2 characters required")
	@JsonProperty("user_name")
	 private String name ;
	@Past(message = "birthdate should be in the  paste")
	@JsonProperty("Birth_day")
	 private LocalDate birthdate;
	 
	 public User() {
		 
	 }
	 
	public User(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	
	 
	 
}
