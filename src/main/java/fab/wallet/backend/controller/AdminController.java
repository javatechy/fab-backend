package fab.wallet.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fab.wallet.backend.api.Response;

/**
 * Admin Controller for all admin operations.
 * @author deepak
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class AdminController {


	@RequestMapping(value = "fab/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public Response fetchUsers(HttpServletRequest request, HttpServletResponse response) {
		return null;//userService.getAllUsers();
	}

}
