package fab.wallet.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.api.Response;
import fab.wallet.backend.dao.TransactionDao;
import fab.wallet.backend.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public Response getBalanceByUserId(Long userId) {
		Response response = new Response();
		response.setTransactions(transactionDao.findByUserId(userId));
		return response;
	}

	@Override
	public Response getAllTransactions() {
		return null;
	}
}