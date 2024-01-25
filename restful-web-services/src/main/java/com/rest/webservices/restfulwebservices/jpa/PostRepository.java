package com.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.*;

import com.rest.webservices.restfulwebservices.user.Post;
import com.rest.webservices.restfulwebservices.user.User;

public interface PostRepository  extends JpaRepository<Post,Integer> {

}
