package fab.wallet.backend.service;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;

public interface UserService {
	
	Response getAllUsers();
	Response getAllTransactions();
	Response authenticateUser(Request request);
}
