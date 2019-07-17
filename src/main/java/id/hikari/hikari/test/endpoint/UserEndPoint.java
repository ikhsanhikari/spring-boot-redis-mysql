package id.hikari.hikari.test.endpoint;


import id.hikari.hikari.test.data.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserEndPoint {
    @GetMapping(value = "")
    ResponseEntity<List<User>> getUsers();

    @GetMapping(value = "/{id}")
    ResponseEntity<User> getUsers(@PathVariable("id") final String userId);

    @PostMapping(value = "")
    ResponseEntity<Void> createUser(@RequestBody final User user);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") final String userId);
}
