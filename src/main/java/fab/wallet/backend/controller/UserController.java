package fab.wallet.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fab.wallet.backend.api.Request;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.service.TransactionService;
import fab.wallet.backend.service.UserService;

@CrossOrigin(origins="*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionService transactionService;


	@RequestMapping(value = "/fab/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public Response fetchUsers(@RequestBody Request request, HttpServletRequest httpRequest,
			HttpServletResponse response) throws Exception {
		return userService.authenticateUser(request);
	}
	
	@RequestMapping(value = "/fab/purchase", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public Response purchase(@RequestBody Request request, HttpServletRequest httpRequest,
			HttpServletResponse response) throws Exception {
		return transactionService.purchaseItem(request);
	}
	
	@RequestMapping(value = "/fab/balance/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public Response getBalance(@NotNull  @PathVariable Long userId, HttpServletRequest httpRequest,
			HttpServletResponse response) throws Exception {
		return userService.getBalanceByUserId(userId);
	}
}
