package fab.wallet.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;

import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.service.UserService;

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
}