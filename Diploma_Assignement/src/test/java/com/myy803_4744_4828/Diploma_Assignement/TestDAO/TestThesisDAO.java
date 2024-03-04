package com.myy803_4744_4828.Diploma_Assignement.TestDAO;

import myy803.diplomas_mgt_app_skeleton.dao.ThesisDAO;
import myy803.diplomas_mgt_app_skeleton.model.Thesis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = ThesisDAO.class)
public class TestThesisDAO {

    @Autowired
    ThesisDAO thesisDAO;

    @Test
    void thesisDAOJPAisNotNull()
    {
        Assertions.assertNotNull(thesisDAO);
    }

    @Test
    void testFindByIdReturnsThesis(){
        Thesis storedThesis = thesisDAO.findById(1);

        Assertions.assertNotNull(storedThesis);

        Assertions.assertEquals("Panagotis", storedThesis.getStudent().getUsername());
    }

    @Test
    void testFindAllReturnsListThesis(){
        List<Thesis> storedThesis = thesisDAO.findAll();
        Assertions.assertNotNull(storedThesis);
        Assertions.assertEquals(1, storedThesis.size());
    }
}
