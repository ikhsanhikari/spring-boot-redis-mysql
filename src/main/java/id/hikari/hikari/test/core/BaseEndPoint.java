package id.hikari.hikari.test.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseEndPoint<T,ID> {
    ResponseEntity save(@RequestBody T t);

    ResponseEntity findAll();

    ResponseEntity findById(@PathVariable("id") ID id);

    ResponseEntity delete(@PathVariable("id") ID id);
}
