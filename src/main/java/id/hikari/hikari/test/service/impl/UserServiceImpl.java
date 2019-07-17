package id.hikari.hikari.test.service.impl;



import id.hikari.hikari.test.dao.UserDAO;
import id.hikari.hikari.test.dao.UserRedisDAO;
import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.data.dto.response.SuccessResponse;
import id.hikari.hikari.test.data.model.User;
import id.hikari.hikari.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserRedisDAO userRedisDAO;

	@Override
	public ResponseEntity save(User user) {
		if(isExist(user.getId())){
			User user1 = userDAO.save(user);
			userRedisDAO.deleteCache("*");
			userRedisDAO.deleteCache(user.getId());
			return ResponseEntity.ok(new SuccessResponse("Users","Success Update Data",user1));
		}else{
			User user1 = userDAO.save(user);
			userRedisDAO.deleteCache("*");
			return ResponseEntity.ok(new SuccessResponse("Users","Success Saving Data",user1));
		}

	}

	@Override
	public DataResponse select() {
		User[] users = userRedisDAO.selectFromCache("*");
		if (users!=null ) {
			return new DataResponse("All Users","Users",users);
		} else {
			List<User> usersDB = userDAO.findAll();
			userRedisDAO.setToCache("*",usersDB);
			return new DataResponse("All Users","Users",usersDB);
		}
	}



	@Override
	public DataResponse get(String id) {
		User user = userRedisDAO.getFromCache(id);
		if(user!=null){
			return new DataResponse(id,"Users",user);
		}else{
			User user1 = userDAO.findById(id).orElse(null);
			userRedisDAO.setToCache(id,user1);
			return new DataResponse(id,"Users",user1);
		}
	}

	@Override
	public ResponseEntity delete(String id) throws Exception {
		if(!isExist(id)) {
			throw new Exception("Failed To Get Data");
		}
		User user = new User();
		user.setId(id);
		userDAO.delete(user);

		userRedisDAO.deleteCache("*");
		userRedisDAO.deleteCache(user.getId());

		return ResponseEntity.ok(new SuccessResponse("Users","Success Delete User",id));
	}

	private Boolean isExist(String id){
		DataResponse userCek = get(id);
		if(userCek.getAttributes()!=null){
			return true;
		}
		return false;
	}

}