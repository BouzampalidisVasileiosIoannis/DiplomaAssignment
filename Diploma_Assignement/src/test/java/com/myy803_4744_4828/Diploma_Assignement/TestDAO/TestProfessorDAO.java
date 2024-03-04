package com.myy803_4744_4828.Diploma_Assignement.TestDAO;

import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
import myy803.diplomas_mgt_app_skeleton.model.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest

@TestPropertySource(locations = "classpath:application.properties")

public class TestProfessorDAO {
    @Autowired
    ProfessorDAO professorDAO;

    @Test
    void testProfessorDAOJPAIsNotNull(){
        Assertions.assertNotNull(professorDAO);
    }

    @Test
    void testFindByIdReturnsProfessor(){
        Professor storedProfessor = professorDAO.findById(1);
        Assertions.assertNotNull(storedProfessor);
        Assertions.assertEquals("zarras", storedProfessor.getUsername());
    }

    @Test
    void testFindByUsernameReturnsProfessor(){
        Professor storedProfessor = professorDAO.findByUsername("zarras");
        Assertions.assertNotNull(storedProfessor);
        Assertions.assertEquals("zarras", storedProfessor.getUsername());
    }

}
