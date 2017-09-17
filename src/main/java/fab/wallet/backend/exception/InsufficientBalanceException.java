package fab.wallet.backend.exception;

public class InsufficientBalanceException extends Exception{

	private static final long serialVersionUID = 1L;
	public InsufficientBalanceException(String message) {
		super(message);
	}

}
