package com.myy803_4744_4828.Diploma_Assignement.TestDAO;

import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestStudentDAO {
    @Autowired
    StudentDAO studentDAO;



    @Test
    void testStudentDAOJPAIsNotNull(){
        Assertions.assertNotNull(studentDAO);
    }



    @Test
    void testFindByIdReturnsStudent(){
        Student storedStudent = studentDAO.findById(1);
        Assertions.assertNotNull(storedStudent);
        Assertions.assertEquals("Kostas", storedStudent.getUsername());
    }



    @Test
    void testFindByUsernameReturnsStudent(){
        Student storedStudent = studentDAO.findByUsername("Kostas");
        Assertions.assertNotNull(storedStudent);
        Assertions.assertEquals("Kostas", storedStudent.getUsername());
    }

}
