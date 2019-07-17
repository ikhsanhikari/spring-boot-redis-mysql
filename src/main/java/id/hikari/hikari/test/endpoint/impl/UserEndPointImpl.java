package id.hikari.hikari.test.endpoint.impl;


import id.hikari.hikari.test.data.dto.response.ErrorResponse;
import id.hikari.hikari.test.data.model.User;
import id.hikari.hikari.test.endpoint.UserEndPoint;
import id.hikari.hikari.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserEndPointImpl implements UserEndPoint {

	@Autowired
	private UserService userService;


    public ResponseEntity getUsers() {
		return ResponseEntity.ok(userService.select());
	}


    public ResponseEntity getUsers(@PathVariable("id") final String userId) {
    	return ResponseEntity.ok(userService.get(userId));
	}


    public ResponseEntity<Void> createUser(@RequestBody final User user) {
    	return userService.save(user);
	}


    public ResponseEntity<Void> deleteUser(@PathVariable("id") final String userId) {
		try {
			return userService.delete(userId);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorResponse("Users",e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

}
