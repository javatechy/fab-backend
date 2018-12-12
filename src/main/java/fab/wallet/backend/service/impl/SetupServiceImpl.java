package fab.wallet.backend.service.impl;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.service.SetupService;

/**
 * Service implementation of the {@link SetupService}
 * 
 * @author deepak
 *
 */
@Service
public class SetupServiceImpl implements SetupService {


	/**
	 * {@inheritDoc}
	 */
	@PostConstruct
	@Override
	public void addUsers() {
		
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
		//
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
		return null;
	}
}