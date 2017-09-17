package fab.wallet.backend.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.dao.BalanceDao;
import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.service.SetupService;
import fab.wallet.backend.util.Constant;

/**
 * Service implementation of the {@link SetupService}
 * 
 * @author deepak
 *
 */
@Service
public class SetupServiceImpl implements SetupService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BalanceDao balanceDao;

	/**
	 * {@inheritDoc}
	 */
	// @PostConstruct
	@Override
	public void addUsers() {
		userDao.deleteAll();
		balanceDao.deleteAll();
		addUser(Constant.ROLE_ADMIN, "admin", "admin");
		addUser(Constant.ROLE_ADMIN, "admin2", "admin2");
		addUserWithBalance(Constant.ROLE_NON_ADMIN, "deepak", "deepak", 5000L);
		addUserWithBalance(Constant.ROLE_NON_ADMIN, "anant", "anant", 1000L);
		addUserWithBalance(Constant.ROLE_NON_ADMIN, "user1", "user1", 8000L);
		addUserWithBalance(Constant.ROLE_NON_ADMIN, "user2", "user2", 100L);
	}

	/**
	 * Creates a user and adds balance of the user.
	 * 
	 * @param role
	 *            Role of the user - ADMIN/NON_ADMIN
	 * @param userName
	 *            userName of the User
	 * @param password
	 *            password of the User
	 * @param walletBalance
	 *            balance of the User
	 */
	private void addUserWithBalance(String role, String userName, String password, Long walletBalance) {
		User user = this.addUser(role, userName, password);
		Balance balance = new Balance();
		balance.setUserId(user.getUserId());
		balance.setBalance(walletBalance);
		balance.setCreatedOn(LocalDateTime.now());
		balance.setUpdatedOn(LocalDateTime.now());
		balanceDao.save(balance);
	}

	/**
	 * Creates a User
	 * 
	 * @param role
	 *            Role of the user - ADMIN/NON_ADMIN
	 * @param userName
	 *            userName of the User
	 * @param password
	 *            password of the User
	 * @return created User object.
	 */
	private User addUser(String role, String userName, String password) {
		User user = new User();
		user.setRole(role);
		user.setUserName(userName);
		user.setPassword(password);
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		return userDao.save(user);
	}
}