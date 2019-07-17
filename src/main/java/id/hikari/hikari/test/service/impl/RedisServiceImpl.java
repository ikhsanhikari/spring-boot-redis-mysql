package id.hikari.hikari.test.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl {

    @Cacheable(cacheNames = "hikarichache", key = "'hikari:'.concat(#name)")
    public String createCache(String name){
        System.out.println("Returning NOT from cache!");
        return "cache have been saving "+name;
    }



    @CacheEvict(cacheNames = "hikarichache")
    public void forgetAboutThis(){
        System.out.println("Forgetting everything about this!");
    }



}
