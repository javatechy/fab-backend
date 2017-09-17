package fab.wallet.backend.exception;

public class WalletNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public WalletNotFoundException(String message) {
		super(message);
	}

}
