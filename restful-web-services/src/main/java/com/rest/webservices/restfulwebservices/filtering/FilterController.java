package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1","feild2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("somebeanfilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList( new SomeBean("value1","value2","value3"),
	              new SomeBean("value11","value22","value33"),
	              new SomeBean("value111","value222","value333"),
	              new SomeBean("value1111","value2222","value3333"),
	              new SomeBean("value11111","value22222","value33333")) ;
		MappingJacksonValue mappingjacksonvalue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1","feild3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("somebeanfilter", filter);
		mappingjacksonvalue.setFilters(filters);
		
		return mappingjacksonvalue ;
	}
}
