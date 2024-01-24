package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	
	private static int usercounter = 0;
	private static List<User> users = new ArrayList();
	
	static {
		
		users.add(new User(++usercounter,"superman",LocalDate.now().minusYears(20)));
		users.add(new User(++usercounter,"ironman",LocalDate.now().minusYears(20)));
		users.add(new User(++usercounter,"spiderman",LocalDate.now().minusYears(20)));
		users.add(new User(++usercounter,"batman",LocalDate.now().minusYears(20)));
		users.add(new User(++usercounter,"hulk",LocalDate.now().minusYears(20)));
	}
	
	
	public List<User> showData(){
  	  return users;
    }


	public User OneUser(int id) {
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
    public void deleteUser(int id) {
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}


	public User save(User user) {
		user.setId(++usercounter);
		users.add(user);
		return user;
	}


	
}

      
