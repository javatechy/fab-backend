package fab.wallet.backend.service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;

public interface TransactionService {
	
	Response getAllTransactions();
	Response getBalanceByUserId(Long userId);
	Response purchaseItem(Request request);
}
