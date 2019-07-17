package id.hikari.hikari.test.endpoint.impl;


import id.hikari.hikari.test.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisEndPoint {

    @Autowired
    RedisServiceImpl redisService;


    @GetMapping("/redis/{name}")
    public String save(@PathVariable String name){
        String first = redisService.createCache(name);
        System.out.println(first);

        String second = redisService.createCache(name);
        System.out.println(second);

        return redisService.createCache(name);
    }

    @DeleteMapping("/redis")
    public String deleteRedis(){
         redisService.forgetAboutThis();
         return "Success Delete Redis";
    }
}
