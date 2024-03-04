package com.myy803_4744_4828.Diploma_Assignement.TestDAO;

import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.model.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestApplicationDAO {

    @Autowired
    ApplicationDAO applicationDAO;

    @Test
    void testApplicationDAOJPAIsNotNull(){
        Assertions.assertNotNull(applicationDAO);
    }

    @Test
    void testFindByIdReturnsApplication(){
        Application storedApplication = applicationDAO.findById(1);
        Assertions.assertNotNull(storedApplication);
        Assertions.assertEquals("Kostas", storedApplication.getStudent().getUsername());
    }

    @Test
    void testFindAllReturnsList(){
        List<Application> storedApplication = applicationDAO.findAll();
        Assertions.assertNotNull(storedApplication);
        Assertions.assertEquals(2, storedApplication.size());
    }

}
