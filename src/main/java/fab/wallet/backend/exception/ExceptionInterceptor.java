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
import fab.wallet.backend.util.Constant;

@EnableWebMvc
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseBody
	public Response userNotFound(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		return buildErrorResponse(Constant.EX_INCORRECT_USERNAME_OR_PASSWORD, ex.getMessage());
	}

	@ExceptionHandler(value = InsufficientBalanceException.class)
	@ResponseBody
	public Response insufficientBalance(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		return buildErrorResponse(Constant.EX_INSUFFICIENT_BALANCE, ex.getMessage());
	}
	@ExceptionHandler(value = WalletNotFoundException.class)
	@ResponseBody
	public Response walletNotFound(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		return buildErrorResponse(Constant.EX_WALLET_NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(value = Exception.class)
	public Response jsonParseException(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) {
		ex.printStackTrace();
		return buildErrorResponse(Constant.EX_UNKOWN_EXCEPTION, Constant.EX_UNKOWN_EXCEPTION_MSG);
	}

	private Response buildErrorResponse(String status, String message) {
		Response response = new Response(Constant.ERROR);
		Error error = new Error();
		error.setStatus(status);
		error.setMessage(message);
		response.setError(error);
		return response;
	}

}
