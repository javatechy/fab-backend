package fab.wallet.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fab.wallet.backend.entity.Transaction;
import fab.wallet.backend.entity.User;

/**
 * DAO layer of {@link Transaction}
 * 
 * @author deepak
 *
 */
@Repository
public interface TransactionDao extends JpaRepository<Transaction, Serializable> {

	/**
	 * Get Transactions based on the user id.
	 * 
	 * @param userId
	 *            userId based on the {@link User}
	 * @return list of Transactions
	 */
	List<Transaction> findByUserId(Long userId);

}
