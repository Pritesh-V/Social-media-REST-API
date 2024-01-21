package com.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResources {

	private UserDaoService service;

	public UserResources(UserDaoService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.showData();
	}
	
	@GetMapping("/users/{id}")
	public User retriveOneuser(@PathVariable int id ){
		return service.OneUser(id);
	}
	
	
	
}
