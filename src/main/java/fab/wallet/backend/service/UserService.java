package fab.wallet.backend.service;

import fab.wallet.backend.api.Response;

public interface UserService {
	
	Response getAllUsers();
	Response getAllTransactions();
}
