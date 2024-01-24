package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	private MessageSource messagesource;
	
	

	public HelloWorld(MessageSource messagesource) {
		super();
		this.messagesource = messagesource;
	}

	@RequestMapping("/hello-world")
	public String Helloworld() {
		return "Hello ";
	}
	
	@RequestMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloworldBean(@PathVariable String name) {
		return  new HelloWorldBean("Hello "+ name);
	}
	
	
	@RequestMapping("/hello-world-internationalized")
	public String Helloworldinternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messagesource.getMessage("good.morning.message", null,"Default Message", locale);
		
	}
}
