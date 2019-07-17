package id.hikari.hikari.test.service;

import id.hikari.hikari.test.data.model.User;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity saveDB(User user);
    ResponseEntity findAllDB();
    ResponseEntity findByIdDB(String id);
    ResponseEntity deleteDB(String id);


}
