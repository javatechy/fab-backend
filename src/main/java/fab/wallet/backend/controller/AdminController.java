package fab.wallet.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fab.wallet.backend.api.Response;
import fab.wallet.backend.service.UserService;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/cbn/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response fetchUsers(@NotNull @PathVariable String userId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/cbn/transactions/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response fetchTransactionsByUserId(@NotNull @PathVariable String userId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return userService.getAllUsers();
	}
}
