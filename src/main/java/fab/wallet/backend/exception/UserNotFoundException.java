package fab.wallet.backend.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7226103290266357090L;
	public UserNotFoundException(String message) {
		super(message);
	}

}
