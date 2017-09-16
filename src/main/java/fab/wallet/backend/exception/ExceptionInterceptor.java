package fab.wallet.backend.exception;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

import fab.wallet.backend.api.Error;
import fab.wallet.backend.api.Response;
import fab.wallet.backend.util.Constant;


@EnableWebMvc
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	/**
	 * @param request
	 * @param response
	 * @param ex
	 * @return
	 * @throws JsonProcessingException 
	 */

	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseBody
	public Response applicationException(HttpServletRequest request, HttpServletResponse httpResponse, Exception ex) throws JsonProcessingException {
		Response response= new Response(Constant.ERROR);
		Error error = new Error();
		error.setStatus(Constant.EX_INCORRECT_USERNAME_OR_PASSWORD);
		error.setMessage(Constant.EX_INCORRECT_USERNAME_OR_PASSWORD_MSG);
		response.setError(error);
		return response;
	}

	@ExceptionHandler(value = Exception.class)
	public Response jsonParseException(HttpServletRequest request, HttpServletResponse httpResponse, Exception aes) throws JsonProcessingException {
		Response response= new Response(Constant.ERROR);
		Error error = new Error();
		error.setStatus(Constant.EX_UNKOWN_EXCEPTION);
		error.setMessage(Constant.EX_UNKOWN_EXCEPTION_MSG);
		response.setError(error);
		return response;

	}
}
