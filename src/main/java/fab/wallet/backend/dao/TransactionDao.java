package fab.wallet.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fab.wallet.backend.entity.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Serializable> {

	List<Transaction> findByUserId(Long userId);

}
