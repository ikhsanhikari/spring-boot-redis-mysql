package id.hikari.hikari.test.endpoint.impl;


import id.hikari.hikari.test.data.model.User;
import id.hikari.hikari.test.endpoint.UserEndPoint;
import id.hikari.hikari.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserEndPointImpl implements UserEndPoint {

	@Autowired
	private UserService userService;


    public ResponseEntity<List<User>> getUsers() {
		return userService.findAllDB();
	}


    public ResponseEntity<User> getUsers(@PathVariable("id") final String userId) {
    	return userService.findByIdDB(userId);
	}


    public ResponseEntity<Void> createUser(@RequestBody final User user) {
    	return userService.saveDB(user);
	}


    public ResponseEntity<Void> deleteUser(@PathVariable("id") final String userId) {
    	return userService.deleteDB(userId);
	}

}
