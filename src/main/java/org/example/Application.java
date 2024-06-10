package org.example;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(org.example.config.AppConfig.class);

    var service = context.getBean(UserService.class);

    var user = new User();
    user.setId(1L);
    user.setFirstName("Manjari");
    user.setLastName("Singh");
    // save in database...
    service.saveUser(user);

    // Test reading data
    var entity = service
      .findById(1L).orElse(null);
    if (entity != null) {
      System.out.println("Found entity: " + entity.getFirstName());
    } else {
      System.out.println("Entity not found");
    }
  }
}