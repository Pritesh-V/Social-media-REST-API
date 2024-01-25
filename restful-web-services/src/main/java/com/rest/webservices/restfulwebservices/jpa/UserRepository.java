package com.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.*;

import com.rest.webservices.restfulwebservices.user.User;

public interface UserRepository  extends JpaRepository<User,Integer> {

}
