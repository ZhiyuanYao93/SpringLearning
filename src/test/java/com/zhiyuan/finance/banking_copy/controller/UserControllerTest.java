package com.zhiyuan.finance.banking_copy.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
import com.zhiyuan.finance.banking_copy.model.UserPersistence;
import com.zhiyuan.finance.banking_copy.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class)
public class UserControllerTest  {

    public static final String BASE_RESOURCE ="/v1/user";

    private static final String CREATE_PERSON = "/person";

    private MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void testCreatePerson() throws Exception {
        PersonPersistence personPersistence = createPerson();
        when(userService.createPerson(any(PersonPersistence.class))).thenReturn(personPersistence);

        mockMvc.perform(post(BASE_RESOURCE+CREATE_PERSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(createPersonString(personPersistence))
        )
                .andExpect(status().isOk());

    }

    private PersonPersistence createPerson(){
        PersonPersistence personPersistence = new PersonPersistence();
        personPersistence.setAge(11);
        personPersistence.setFullName("Mike");
        personPersistence.setCity("LA");

        Set<UserPersistence> userPersistenceSet = new HashSet<UserPersistence>();

        UserPersistence userPersistence1 = new UserPersistence();
        userPersistence1.setName("Steve");
        userPersistence1.setPwd("StevePwd");
        userPersistence1.setPersonPersistence(personPersistence);
        userPersistenceSet.add(userPersistence1);

        personPersistence.setUserPersistenceSet(userPersistenceSet);

        return personPersistence;
    }


    private String createPersonString(PersonPersistence personPersistence){
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();

        try {
            objectMapper.writeValue(stringWriter,personPersistence);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringWriter.toString());
        return stringWriter.toString();

    }


}