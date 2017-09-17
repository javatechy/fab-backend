package fab.wallet.backend.service.impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.dao.BalanceDao;
import fab.wallet.backend.dao.TransactionDao;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.Transaction;
import fab.wallet.backend.exception.InsufficientBalanceException;
import fab.wallet.backend.exception.WalletNotFoundException;
import fab.wallet.backend.service.TransactionService;
import fab.wallet.backend.service.UserService;
import fab.wallet.backend.util.Constant;

/**
 * Service implementation of {@link TransactionService}.
 * @author deepak
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private BalanceDao balanceDao;
	

	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response getTransactionsByUserId(Long userId) {
		Response response = new Response(Constant.STATUS_SUCCESS);
		response.setTransactions(transactionDao.findByUserId(userId));
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response getAllTransactions() {
		Response response = new Response(Constant.STATUS_SUCCESS);
		response.setTransactions(transactionDao.findAll());
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Response purchaseItem(Request request) throws InsufficientBalanceException, WalletNotFoundException {
		Long serviceAmount = request.getAmount();
		Balance balance = userService.getBalanceByUserId(request.getUserId()).getBalance();
		Long oldBalance = balance.getBalance();
		Long newBalance = oldBalance - serviceAmount;
		if (newBalance < 0 ) {
			throw new InsufficientBalanceException(
					"Tranaction amount > Balance !!!! Transaction Amount  :"
							+ request.getAmount() + "\n Avaliable Balance:" + balance.getBalance());
		}
		balance.setBalance(newBalance);
		balance.setUpdatedOn(LocalDateTime.now());
		balanceDao.save(balance);
		Transaction transaction = new Transaction();
		transaction.setUserId(request.getUserId());
		transaction.setTransactionType(request.getTransactionType());
		transaction.setOldBalance(oldBalance);
		transaction.setNewBalance(newBalance);
		transaction.setCreatedOn(LocalDateTime.now());
		transaction.setUpdatedOn(LocalDateTime.now());
		transaction.setTransactionAmount(serviceAmount);
		transactionDao.save(transaction);
		Response response = new Response(Constant.STATUS_SUCCESS);
		return response;
	}
}