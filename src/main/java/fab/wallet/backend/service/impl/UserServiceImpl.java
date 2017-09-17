package fab.wallet.backend.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.commons.Constant;
import fab.wallet.backend.dao.BalanceDao;
import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.exception.UserNotFoundException;
import fab.wallet.backend.exception.WalletNotFoundException;
import fab.wallet.backend.service.UserService;

/**
 * Service Implementation for {@link UserService}
 * 
 * @author deepak
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BalanceDao balanceDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response getAllUsers() {
		Response response = new Response(Constant.STATUS_SUCCESS);
		response.setUsers(userDao.findAllByRole(Constant.ROLE_NON_ADMIN));
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response authenticateUser(Request request) throws UserNotFoundException {
		Response response = new Response(Constant.STATUS_SUCCESS);
		String userName = request.getUserName();
		String password = request.getPassword();
		User user = userDao.findByUserNameAndPassword(userName, password);
		if (Objects.isNull(user)) {
			throw new UserNotFoundException("No User found with username: " + userName + " and password " + password);
		}
		response.setUser(user);
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response getBalanceByUserId(Long userId) throws WalletNotFoundException {
		Response response = new Response(Constant.STATUS_SUCCESS);
		Balance balance = balanceDao.getBalanceByUserId(userId);
		if (Objects.isNull(balance)) {
			throw new WalletNotFoundException("Wallet not found for the userId: " + userId);
		}
		response.setBalance(balance);
		return response;
	}
}