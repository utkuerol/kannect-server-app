package com.pse.testserver.Unit.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest
@OverrideAutoConfiguration(enabled = true)
public class UserControllerUnitTest {

    List<User> mockUsers = new LinkedList<>();
    User user1;
    User user2;
    User user3;
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userService;

    @Before
    public void setup() {
        user1 = new User();
        user2 = new User();
        user3 = new User();

        user1.setName("user1");
        user2.setName("user2");
        user3.setName("user3");

        mockUsers.add(user1);
        mockUsers.add(user2);
        mockUsers.add(user3);

    }

    @Test
    public void getUsersTest() throws Exception {

        Mockito.when(userService.getAllByName(Mockito.anyString()))
                .thenReturn(mockUsers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockUsers);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }


}
