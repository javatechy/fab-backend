package fab.wallet.backend.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.dao.BalanceDao;
import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.exception.UserNotFoundException;
import fab.wallet.backend.exception.WalletNotFoundException;
import fab.wallet.backend.service.UserService;
import fab.wallet.backend.util.Constant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BalanceDao balanceDao;

	@Override
	public Response getAllUsers() {
		Response response = new Response(Constant.SUCESS);
		response.setUsers(userDao.findAll());
		return response;
	}

	@Override
	public Response getAllTransactions() {
		Response response = new Response(Constant.SUCESS);
		response.setUsers(userDao.findAll());
		return response;
	}

	@Override
	public Response authenticateUser(Request request) {
		Response response = new Response(Constant.SUCESS);
		String userName = request.getUserName();
		String password = request.getPassword();
		User user = userDao.findByUserNameAndPassword(userName, password);
		if (Objects.isNull(user)) {
			throw new UserNotFoundException(
					String.join("", "No User found with username:", userName, "and password", password));
		}
		response.setUser(user);
		return response;
	}

	@Override
	public Response getBalanceByUserId(Long userId) {
		Response response = new Response(Constant.SUCESS);
		Balance balance = balanceDao.getBalanceByUserId(userId);
		if (Objects.isNull(balance)) {
			throw new WalletNotFoundException("Entry not found for the user" + userId);
		}
		response.setBalance(balance);
		return null;
	}
}