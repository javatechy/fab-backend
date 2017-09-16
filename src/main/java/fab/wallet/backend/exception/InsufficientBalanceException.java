package fab.wallet.backend.exception;

public class InsufficientBalanceException extends RuntimeException{

	private static final long serialVersionUID = -7226103290266357090L;
	public InsufficientBalanceException(String message) {
		super(message);
	}

}
