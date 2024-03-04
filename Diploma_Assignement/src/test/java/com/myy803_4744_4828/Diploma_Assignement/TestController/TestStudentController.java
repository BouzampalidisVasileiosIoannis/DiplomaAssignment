package com.myy803_4744_4828.Diploma_Assignement.TestController;
import myy803.diplomas_mgt_app_skeleton.controller.StudentController;
import myy803.diplomas_mgt_app_skeleton.service.StudentService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class TestStudentController {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    StudentController studentController;

    @MockBean
    SubjectService subjectService;

    @MockBean
    StudentService studentService;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testStudentControllerIsNotNull(){
        Assertions.assertNotNull(studentController);
    }

    @Test
    void testMockMvcIsNotNull(){
        Assertions.assertNotNull(mockMvc);
    }
    @WithMockUser(value = "giannis")
    @Test
    void testStudentMainMenuPage() throws Exception{
        mockMvc.perform(get("/student/main-menu")).
                andExpect(status().isOk()).
                andExpect(view().name("student/main-menu"));
    }
}
