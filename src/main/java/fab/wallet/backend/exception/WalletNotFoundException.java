package fab.wallet.backend.exception;

public class WalletNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7226103290266357090L;
	public WalletNotFoundException(String message) {
		super(message);
	}

}
