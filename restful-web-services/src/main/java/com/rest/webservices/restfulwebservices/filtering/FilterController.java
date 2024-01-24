package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		return someBean;
	}
	

	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList( new SomeBean("value1","value2","value3"),
				              new SomeBean("value11","value22","value33"),
				              new SomeBean("value111","value222","value333"),
				              new SomeBean("value1111","value2222","value3333"),
				              new SomeBean("value11111","value22222","value33333")) ;
	}
}
