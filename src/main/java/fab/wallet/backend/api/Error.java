package fab.wallet.backend.api;

/**
 * Error containing information when an exception occurs.
 * 
 * @author deepak
 */
public class Error {
	private String status;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
