package fab.wallet.backend.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fab.wallet.backend.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Serializable> {

	User findByUserNameAndPassword(String userName, String password);
}
