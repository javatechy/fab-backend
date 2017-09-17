package fab.wallet.backend.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fab.wallet.backend.entity.Balance;

/**
 * DAO for {@link Balance}.
 * 
 * @author deepak
 *
 */
@Repository
public interface BalanceDao extends JpaRepository<Balance, Serializable> {

	/**
	 * Get balance based on user Id
	 * 
	 * @param userId
	 *            user Id of user.
	 * @return Balance of a user
	 */
	Balance getBalanceByUserId(Long userId);

}
