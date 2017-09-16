package fab.wallet.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.wallet.backend.dao.UserDao;
import fab.wallet.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;
}