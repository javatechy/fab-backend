package fab.wallet.backend.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fab.wallet.backend.api.Error;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.commons.Constant;

/**
 * Global Exception Handler
 * 
 * @author deepak
 *
 */
@EnableWebMvc
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	/**
	 * When user not found
	 * 
	 * @param request
	 *            Request
	 * @param httpResponse
	 *            Http Response
	 * @param ex
	 *            Exception
	 * @return Response to the client
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseBody
	public Response userNotFound(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		return buildErrorResponse(Constant.EX_INCORRECT_USERNAME_OR_PASSWORD, ex.getMessage());
	}

	/**
	 * When balance is not sufficient
	 * 
	 * @param request
	 *            Request
	 * @param httpResponse
	 *            Http Response
	 * @param ex
	 *            Exception
	 * @return Response to the client
	 */
	@ExceptionHandler(value = InsufficientBalanceException.class)
	@ResponseBody
	public Response insufficientBalance(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		return buildErrorResponse(Constant.EX_INSUFFICIENT_BALANCE, ex.getMessage());
	}

	/**
	 * 
	 * When wallet for a user not found
	 * 
	 * @param request
	 *            Request
	 * @param httpResponse
	 *            Http Response
	 * @param ex
	 *            Exception
	 * @return Response to the client
	 */
	@ExceptionHandler(value = WalletNotFoundException.class)
	@ResponseBody
	public Response walletNotFound(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		return buildErrorResponse(Constant.EX_WALLET_NOT_FOUND, ex.getMessage());
	}

	/**
	 * Parent exception
	 * 
	 * @param request
	 *            Request
	 * @param httpResponse
	 *            Http Response
	 * @param ex
	 *            Exception
	 * @return Response to the client
	 */
	@ExceptionHandler(value = Exception.class)
	public Response parentException(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		ex.printStackTrace();
		return buildErrorResponse(Constant.EX_UNKOWN_EXCEPTION, Constant.EX_UNKOWN_EXCEPTION_MSG);
	}

	/**
	 * Build Error Response based on the status and message.
	 * 
	 * @param status
	 *            internal error code based on the Exception
	 * @param message
	 *            Exception message
	 * @return
	 */
	private Response buildErrorResponse(String status, String message) {
		Response response = new Response(Constant.ERROR);
		Error error = new Error();
		error.setStatus(status);
		error.setMessage(message);
		response.setError(error);
		return response;
	}

}
