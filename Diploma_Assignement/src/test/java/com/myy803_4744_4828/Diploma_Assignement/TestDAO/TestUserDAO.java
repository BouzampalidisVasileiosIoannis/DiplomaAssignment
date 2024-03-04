package com.myy803_4744_4828.Diploma_Assignement.TestDAO;


import myy803.diplomas_mgt_app_skeleton.dao.UserDAO;
import myy803.diplomas_mgt_app_skeleton.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import java.util.Optional;

@SpringBootTest
@ContextConfiguration(classes = UserDAO.class)
//@TestPropertySource(locations = "classpath:application.properties")
public class TestUserDAO {
    @Autowired
    UserDAO userDAO;

    @Test
    void testUserDAOJPAIsNotNull(){
        Assertions.assertNotNull(userDAO);
    }

    @Test
    void testFindByIdReturnsUser(){
        User storedUser = userDAO.findById(2);
        Assertions.assertNotNull(storedUser);
        Assertions.assertEquals("Panagiotis", storedUser.getUsername());
    }

    @Test
    void testFindByUsernameReturnsUser(){
        Optional<User> storedUser = userDAO.findByUsername("Kostas");
        Assertions.assertNotNull(storedUser);
        Assertions.assertEquals("Kostas", storedUser.get().getUsername());
    }
}
