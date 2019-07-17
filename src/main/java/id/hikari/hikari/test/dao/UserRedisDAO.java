package id.hikari.hikari.test.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import id.hikari.hikari.test.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDAO {

    @Autowired
    public RedisTemplate<String, String> userTemplateList;

    public static final String REDIS_PREFIX_USERS = "users";

    public static final String REDIS_KEYS_SEPARATOR = ":";

    public User[] selectFromCache(String redisKey){
        String result = userTemplateList.opsForValue().get(getRedisKey(redisKey));
        return convertToJsonArray(result);
    }

    public User getFromCache(String redisKey){
        String result = userTemplateList.opsForValue().get(getRedisKey(redisKey));
        return convertToJson(result);
    }

    public void setToCache(String redisKey,Object users){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(users);
            userTemplateList.opsForValue().set(getRedisKey(redisKey), jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public String getRedisKey(final String userId) {
        return REDIS_PREFIX_USERS + REDIS_KEYS_SEPARATOR + userId;
    }


    public User[] convertToJsonArray(String json){
        Gson gson = new Gson();
        User[] result = gson.fromJson(json, User[].class);
        return result;
    }

    public User convertToJson(String json){
        Gson gson = new Gson();
        User result = gson.fromJson(json, User.class);
        return result;
    }

    public void deleteCache(String redisKey){
        userTemplateList.delete(getRedisKey(redisKey));
    }
}
