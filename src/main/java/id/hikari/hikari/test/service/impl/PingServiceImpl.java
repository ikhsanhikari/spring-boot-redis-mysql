package id.hikari.hikari.test.service.impl;

import id.hikari.hikari.test.dao.PingDAO;
import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.data.model.Ping;
import id.hikari.hikari.test.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PingServiceImpl implements PingService {

    @Autowired
    private PingDAO pingDAO;



//    @Cacheable(cacheNames = "ping",key = "'ping1'")
    @Override
    public ResponseEntity readAll() {
        List<Ping> pings = pingDAO.findAll();
        if(pings.size()>0){
            return ResponseEntity.ok(new DataResponse("1","Pings",pings));
        }else{
            return  ResponseEntity.badRequest().body("List ping not found ");
        }

    }

    @Override
    public ResponseEntity readById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity save(Ping ping) {
        return null;
    }

    @Override
    public ResponseEntity update(Ping ping) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }


}
