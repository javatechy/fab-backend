package fab.wallet.backend.service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.Transaction;
import fab.wallet.backend.exception.InsufficientBalanceException;
import fab.wallet.backend.exception.WalletNotFoundException;

/**
 * The service interface to manage transactions and to purchase any item.
 * 
 * @author deepak
 *
 */
public interface TransactionService {

	/**
	 * Retrieve all transactions in the database for all users.
	 * 
	 * @return Response containing status and list of transactions.
	 */
	Response getAllTransactions();

	/**
	 * Retrieve all transactions in the database for a user.
	 * 
	 * @param userId
	 *            UserId of the user
	 * @return Response containing status and list of transactions.
	 */
	Response getBalanceByUserId(Long userId);

	/**
	 * Manage transactions - Deducting balance,Making entry in {@link Transaction}
	 * table and updating {@link Balance} table.
	 * 
	 * @param request
	 * @return Response containing status
	 * @throws InsufficientBalanceException 
	 * @throws WalletNotFoundException 
	 */
	Response purchaseItem(Request request) throws InsufficientBalanceException, WalletNotFoundException;
}
