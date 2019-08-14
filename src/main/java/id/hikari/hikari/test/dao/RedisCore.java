package id.hikari.hikari.test.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCore<T> {

    public static final String REDIS_PREFIX_USERS = "users";

    public static final String REDIS_KEYS_SEPARATOR = ":";

    @Autowired
    public RedisTemplate<String, String> userTemplateList;

    public void setToCache(String redisKey,Object t){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(t);
            userTemplateList.opsForValue().set(getRedisKey(redisKey), jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void deleteCache(String redisKey){
        userTemplateList.delete(getRedisKey(redisKey));
    }

    public String getRedisKey(final String userId) {
        return REDIS_PREFIX_USERS + REDIS_KEYS_SEPARATOR + userId;
    }
}
