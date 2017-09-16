package fab.wallet.backend.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fab.wallet.backend.entity.Balance;

@Repository
public interface BalanceDao extends JpaRepository<Balance, Serializable> {

	Balance getBalanceByUserId(Long userId);

}
