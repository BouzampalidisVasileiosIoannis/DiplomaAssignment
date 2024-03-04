package com.myy803_4744_4828.Diploma_Assignement.TestDAO;

import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.model.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest

@TestPropertySource(locations = "classpath:application.properties")

public class TestSubjectDAO {

    @Autowired
    SubjectDAO subjectDAO;

    @Test
    void testSubjectDAOJPAIsNotNull(){
        Assertions.assertNotNull(subjectDAO);
    }

    @Test
    void testFindByIdReturnsThesis(){
        Subject storedSubject = subjectDAO.findById(2);
        Assertions.assertNotNull(storedSubject);
        Assertions.assertEquals("Digital 1", storedSubject.getTitle());
    }

    @Test
    void testFindByTitleReturnsSubject(){
        Subject storedSubject = subjectDAO.findByTitle("Databases 2");
        Assertions.assertNotNull(storedSubject);
        Assertions.assertEquals("Databases 2", storedSubject.getTitle());
    }

    @Test
    void testFindAllReturnsListSubject(){
        List<Subject> storedSubject = subjectDAO.findAll();
        Assertions.assertNotNull(storedSubject);
        Assertions.assertEquals(2, storedSubject.size());
    }

    @Test
    void testDeleteByTitleDeleteSubject(){
        Subject storedSubject = subjectDAO.findById(1);
        Assertions.assertNotNull(storedSubject);
        Assertions.assertEquals("Databases 2", storedSubject.getTitle());
        subjectDAO.deleteById(1);
        Assertions.assertNull(storedSubject);
    }



}
