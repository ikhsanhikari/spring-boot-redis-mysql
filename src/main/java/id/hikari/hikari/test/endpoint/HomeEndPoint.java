package id.hikari.hikari.test.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface HomeEndPoint {

    @GetMapping("/ping")
    ResponseEntity ping();

}
