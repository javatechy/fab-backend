package fab.wallet.backend.service.impl;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.dao.BalanceDao;
import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.entity.Balance;
import fab.wallet.backend.entity.User;
import fab.wallet.backend.service.SetupService;
import fab.wallet.backend.util.Constant;

@Service
public class SetupServiceImpl implements SetupService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BalanceDao balanceDao;
	
	@PostConstruct
	public void addUsers(){
		userDao.deleteAll();
		balanceDao.deleteAll();
		addUser(Constant.ROLE_ADMIN,"admin","admin");
		addUserWithBalance(Constant.ROLE_NON_ADMIN,"deepak","deepak",5000L);
		addUserWithBalance(Constant.ROLE_NON_ADMIN,"anant","anant",1000L);
	}

	private void addUserWithBalance( String role,String userName, String password, Long walletBalance) {
		User user = this.addUser(role, userName, password);
		Balance balance = new Balance();
		balance.setUserId(user.getUserId());
		balance.setBalance(walletBalance);
		balance.setCreatedOn(LocalDateTime.now());
		balance.setUpdatedOn(LocalDateTime.now());
		balanceDao.save(balance);
	}

	private User addUser(String role,String userName, String password) {
		User user = new User();
		user.setRole(role);
		user.setUserName(userName);
		user.setPassword(password);
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		return userDao.save(user);	
	}

	@Override
	public void addWalletBalances() {
		// TODO Auto-generated method stub
		
	}
}