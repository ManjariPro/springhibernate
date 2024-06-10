package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }

  public Optional<User> findById(Long id) {

    return userDao.findById(id);
  }

  public boolean saveUser(User user) {
    userDao.saveUser(user);

    return true;
  }
}