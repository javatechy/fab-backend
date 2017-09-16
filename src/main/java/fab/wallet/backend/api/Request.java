package fab.wallet.backend.api;

/**
 * @author deepak
 */
public class Request {
	private String userName;
	private String password;
	private String transactionType;
	private Long amount;
	private Long userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Request [userName=" + userName + ", password=" + password + ", transactionType=" + transactionType
				+ ", amount=" + amount + "]";
	}

}
