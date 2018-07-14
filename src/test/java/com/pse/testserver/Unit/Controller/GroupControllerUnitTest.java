package com.pse.testserver.Unit.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.entities.Group;
import com.pse.testserver.service.GroupService;
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
public class GroupControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GroupService groupService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Group group1;
    private Group group2;

    private List<Group> mockGroups = new LinkedList<>();

    @Before
    public void setup() {
        group1 = new Group();
        group2 = new Group();
        group1.setName("group1");
        group2.setName("group2");
        mockGroups.add(group1);
        mockGroups.add(group2);
    }

    @Test
    public void getGroupsTest() throws Exception {

        Mockito.when(groupService.getAllByName(Mockito.anyString()))
                .thenReturn(mockGroups);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/groups")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockGroups);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }


}
