package org.example.dao;

import org.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
  @Autowired
  private SessionFactory sessionFactory;

  @Transactional
  public List<User> getAllUsers() {
    return sessionFactory
        .getCurrentSession()
        .createQuery("from User", User.class)
        .list();
  }

  @Transactional
  public Optional<User> findById(Long id) {
    return Optional
      .ofNullable(sessionFactory.getCurrentSession().get(User.class, id));
  }

  @Transactional
  public void saveUser(User user) {
    sessionFactory.getCurrentSession().save(user);
  }
}
