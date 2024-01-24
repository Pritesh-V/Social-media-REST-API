package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
		User user = service.OneUser(id);
		if(user == null) {
			throw new userNotFoundException("id :"+id);
		}
		return user ;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteOneuser(@PathVariable int id ){
	 service.deleteUser(id);
		
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveuser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")		
				.buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	
	
	
}
