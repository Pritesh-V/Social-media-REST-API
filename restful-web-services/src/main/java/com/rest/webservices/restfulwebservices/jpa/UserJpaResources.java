package com.rest.webservices.restfulwebservices.jpa;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.user.Post;
import com.rest.webservices.restfulwebservices.user.User;
import com.rest.webservices.restfulwebservices.user.userNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJpaResources {

	//private UserDaoService service;
	
	private UserRepository repository;
	
	private PostRepository postRepository;

	public UserJpaResources(UserRepository repository,PostRepository postRepository) {
		super();
		
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveOneuser(@PathVariable int id ){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new userNotFoundException("id :"+id);
		}
		EntityModel<User> entitymodel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entitymodel.add(link.withRel("all-users"));
		return entitymodel ;
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteOneuser(@PathVariable int id ){
	 repository.deleteById(id);
		
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostsForUser(@PathVariable int id ){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new userNotFoundException("id :"+id);
		}
		
		return user.get().getPosts() ;
	}
	
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveuser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")		
				.buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id ,@Valid @RequestBody Post post ){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new userNotFoundException("id :"+id);
		}	
		
		post.setUser(user.get());
		Post savedpost = postRepository.save(post);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")		
				.buildAndExpand(savedpost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	
}
