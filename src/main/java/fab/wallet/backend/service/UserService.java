package fab.wallet.backend.service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.exception.UserNotFoundException;
import fab.wallet.backend.exception.WalletNotFoundException;

/**
 * The service interface to manage users.
 * 
 * @author deepak
 *
 */
public interface UserService {

	/**
	 * Returns all NON_ADMIN users.
	 * 
	 * @return {@link Response} with list of all NON_ADMIN users.
	 */
	Response getAllUsers();

	/**
	 * Authenticate User based on username and password.
	 * 
	 * @param request
	 *            {@link Request} containing username and password.
	 * @return {@link Response} containing user object.
	 * @throws UserNotFoundException
	 *             thrown when username/password not present in {@link User} table
	 */
	Response authenticateUser(Request request) throws UserNotFoundException;

	/**
	 * Get user balance based on the userId.
	 * 
	 * @param userId
	 * @return {@link Response} containing {@link Balance} object.
	 * @throws WalletNotFoundException
	 *             thrown when not entry found for the user in {@link Balance} table
	 */
	Response getBalanceByUserId(Long userId) throws WalletNotFoundException;
}
