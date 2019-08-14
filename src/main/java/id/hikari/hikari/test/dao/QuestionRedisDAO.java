package id.hikari.hikari.test.dao;

import com.google.gson.Gson;
import id.hikari.hikari.test.data.dto.response.ResponseQuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRedisDAO extends RedisCore<ResponseQuestionDTO>{
    @Autowired
    public RedisTemplate<String, String> userTemplateList;

    public static final String REDIS_PREFIX_USERS = "questions";

    public static final String REDIS_KEYS_SEPARATOR = ":";

    public ResponseQuestionDTO[] selectFromCache(String redisKey){
        String result = userTemplateList.opsForValue().get(getRedisKey(redisKey));
        return convertToJsonArray(result);
    }

    public ResponseQuestionDTO getFromCache(String redisKey){
        String result = userTemplateList.opsForValue().get(getRedisKey(redisKey));
        return convertToJson(result);
    }
    public String getRedisKey(final String userId) {
        return REDIS_PREFIX_USERS + REDIS_KEYS_SEPARATOR + userId;
    }


    public ResponseQuestionDTO[] convertToJsonArray(String json){
        Gson gson = new Gson();
        ResponseQuestionDTO[] result = gson.fromJson(json, ResponseQuestionDTO[].class);
        return result;
    }

    public ResponseQuestionDTO convertToJson(String json){
        Gson gson = new Gson();
        ResponseQuestionDTO result = gson.fromJson(json, ResponseQuestionDTO.class);
        return result;
    }
}
