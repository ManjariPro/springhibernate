package org.example.dao;

import org.example.config.TestConfig;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(TestConfig.class)
@Transactional
public class UserDaoTest {

  @Autowired
  private UserDao userDao;

  @BeforeEach
  public void setUp() {
    User user = new User();
    user.setId(1L);
    user.setFirstName("Manjari");
    user.setLastName("Singh");
    userDao.saveUser(user);
  }

  @Test
  public void testGetAllUsers() {
    List<User> users = userDao.getAllUsers();
    assertNotNull(users);
    assertEquals(1, users.size());

    User user = users.get(0);
    assertEquals(1L, user.getId());
    assertEquals("Manjari", user.getFirstName());
    assertEquals("Singh", user.getLastName());
  }

  @Test
  public void testSaveUser() {
    User user = new User();
    user.setId(2L);
    user.setFirstName("Manjari2");
    user.setLastName("Singh");

    userDao.saveUser(user);

    List<User> users = userDao.getAllUsers();
    assertEquals(2, users.size());

    User savedUser = users.get(1);
    assertEquals(2L, savedUser.getId());
    assertEquals("Manjari2", savedUser.getFirstName());
    assertEquals("Singh", savedUser.getLastName());
  }
}