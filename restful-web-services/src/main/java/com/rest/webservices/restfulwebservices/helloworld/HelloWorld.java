package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/hello-world")
	public String Helloworld() {
		return "Hello ";
	}
	
	@RequestMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloworldBean(@PathVariable String name) {
		return  new HelloWorldBean("Hello "+ name);
	}
}
