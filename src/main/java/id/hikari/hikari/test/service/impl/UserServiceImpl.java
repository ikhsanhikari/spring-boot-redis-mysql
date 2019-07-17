package id.hikari.hikari.test.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import id.hikari.hikari.test.dao.UserDAO;
import id.hikari.hikari.test.data.model.User;
import id.hikari.hikari.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;


	@Autowired
	private RedisTemplate<String, String> userTemplateList;

	private static final String REDIS_PREFIX_USERS = "users";

	private static final String REDIS_KEYS_SEPARATOR = ":";


	@Override
	public ResponseEntity saveDB(User user) {
		ResponseEntity userCek = findByIdDB(user.getId());
		if(userCek!=null){
			userDAO.save(user);
			deleteCache("*");
			deleteCache(user.getId());
			return ResponseEntity.ok("Success update Data");
		}else{
			userDAO.save(user);
			deleteCache("*");
			return ResponseEntity.ok("Success saving data");
		}

	}

	@Override
	public ResponseEntity findAllDB() {
		User[] users = selectFromCache("*");
		if (users!=null ) {
			return ResponseEntity.ok(users);
		} else {
			List<User> usersDB = userDAO.findAll();
			setToCache("*",usersDB);
			return ResponseEntity.ok(usersDB);
		}
	}

	private User[] selectFromCache(String redisKey){
		String result = userTemplateList.opsForValue().get(getRedisKey(redisKey));
		return convertToJsonArray(result);
	}

	private User getFromCache(String redisKey){
		String result = userTemplateList.opsForValue().get(getRedisKey(redisKey));
		return convertToJson(result);
	}

	private void setToCache(String redisKey,Object users){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(users);
			userTemplateList.opsForValue().set(getRedisKey(redisKey), jsonInString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResponseEntity findByIdDB(String id) {
		User user = getFromCache(id);
		if(user!=null){
			return ResponseEntity.ok(user);
		}else{
			User user1 = userDAO.findById(id).orElse(null);
			setToCache(id,user1);
			return ResponseEntity.ok(user1);
		}
	}

	@Override
	public ResponseEntity deleteDB(String id) {
		User user = new User();
		user.setId(id);
		userDAO.delete(user);
		deleteCache(id);

		return ResponseEntity.ok("Delete Success");
	}

	private String getRedisKey(final String userId) {
		return REDIS_PREFIX_USERS + REDIS_KEYS_SEPARATOR + userId;
	}


	private User[] convertToJsonArray(String json){
		Gson gson = new Gson();
		User[] result = gson.fromJson(json, User[].class);
		return result;
	}

	private User convertToJson(String json){
		Gson gson = new Gson();
		User result = gson.fromJson(json, User.class);
		return result;
	}

	private void deleteCache(String redisKey){
		userTemplateList.delete(getRedisKey(redisKey));
	}
}