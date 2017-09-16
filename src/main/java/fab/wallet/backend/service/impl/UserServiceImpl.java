package fab.wallet.backend.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;

import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.service.UserService;
import fab.wallet.backend.util.Constant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Response getAllUsers() {
		Response response = new Response();
		response.setUsers(userDao.findAll());
		return response;
	}

	@Override
	public Response getAllTransactions() {
		Response response = new Response();
		response.setUsers(userDao.findAll());
		return response;
	}

	@Override
	public Response authenticateUser(Request request) {
		Response response = new Response();
		response.setUser(userDao.findByUserNameAndPassword(request.getUserName(), request.getPassword()));
		return response;
	}
	
	@PostConstruct
	public void addUsers(){
		userDao.deleteAll();
		userDao.save(getUser(Constant.ROLE_ADMIN,"admin","admin"));
		userDao.save(getUser(Constant.ROLE_NON_ADMIN,"deepak","deepak"));
		userDao.save(getUser(Constant.ROLE_NON_ADMIN,"anant","anant"));
	}

	private User getUser(String role,String userName, String password) {
		User user = new User();
		user.setRole(role);
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
}