package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.endpoint.HomeEndPoint;
import id.hikari.hikari.test.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeEndPointImpl implements HomeEndPoint {

    @Autowired
    private PingService pingService;

    @Override
    public ResponseEntity ping() {
        return pingService.readAll();
    }
}
