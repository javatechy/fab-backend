/**
 * 
 */
package fab.wallet.backend.api;

import java.util.List;

import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.Transaction;
import fab.wallet.backend.entity.User;

/**
 * @author deepak
 */
public class Response {

	private String status;
	private List<User> users;
	private User user;
	private List<Balance> balances;
	private Balance balance;
	private List<Transaction> transactions;
	private Transaction trasnaction;
	private Error error;

	public Response(String code) {
		this.status = code;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Balance> getBalances() {
		return balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction getTrasnaction() {
		return trasnaction;
	}

	public void setTrasnaction(Transaction trasnaction) {
		this.trasnaction = trasnaction;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
