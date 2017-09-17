package fab.wallet.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fab.wallet.backend.entity.User;

/**
 * DAO for {@link User}
 * 
 * @author deepak
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Serializable> {

	/**
	 * Get User based on userName and password
	 * 
	 * @param userName
	 *            userName of the user.
	 * @param password
	 *            Password of the user.
	 * @return
	 */
	User findByUserNameAndPassword(String userName, String password);

	List<User> findAllByRole(String role);
}
