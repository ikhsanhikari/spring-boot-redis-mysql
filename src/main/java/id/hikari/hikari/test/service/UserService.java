package id.hikari.hikari.test.service;

import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.data.model.User;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity save(User user);
    DataResponse select();
    DataResponse get(String id);
    ResponseEntity delete(String id) throws Exception;


}
