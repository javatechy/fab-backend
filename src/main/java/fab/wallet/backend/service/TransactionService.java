package fab.wallet.backend.service;

import fab.wallet.backend.api.Response;

public interface TransactionService {
	
	Response getAllTransactions();
	Response getBalanceByUserId(Long userId);
}
