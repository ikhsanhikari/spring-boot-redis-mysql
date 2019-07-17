package id.hikari.hikari.test.service;

import id.hikari.hikari.test.data.model.Ping;
import org.springframework.http.ResponseEntity;

public interface PingService {

    ResponseEntity readAll();

    ResponseEntity readById(Long id);

    ResponseEntity save(Ping ping);

    ResponseEntity update(Ping ping);

    ResponseEntity delete(Long id);


}
