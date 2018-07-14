package com.pse.testserver.Unit.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.entities.Post;
import com.pse.testserver.service.PostService;
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
public class PostControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    private List<Post> mockPosts = new LinkedList<>();

    private Post post1;
    private Post post2;
    private Post post3;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void setup() {
        post1 = new Post();
        post2 = new Post();
        post3 = new Post();
        post1.setText("first post");
        post2.setText("second post");
        post3.setText("third post");

        mockPosts.add(post1);
        mockPosts.add(post2);
        mockPosts.add(post3);
    }

    @Test
    public void getPersonalFeedTest() throws Exception {

        Mockito.when(postService.getPersonalFeed(Mockito.anyInt()))
                .thenReturn(mockPosts);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/personalFeed?userId=1234")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockPosts);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getGroupFeedTest() throws Exception {

        Mockito.when(postService.getAllByGroup(Mockito.anyInt()))
                .thenReturn(mockPosts);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/groupFeed?groupId=42")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockPosts);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getEventFeedTest() throws Exception {

        Mockito.when(postService.getAllByEvent(Mockito.anyInt()))
                .thenReturn(mockPosts);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/eventFeed?eventId=42")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockPosts);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getUserProfileTest() throws Exception {

        Mockito.when(postService.getAllByUser(Mockito.anyInt()))
                .thenReturn(mockPosts);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userProfile?userId=42")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockPosts);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
