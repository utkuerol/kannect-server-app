package com.pse.testserver.Unit.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.entities.Event;
import com.pse.testserver.service.EventService;
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
public class EventControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventService eventService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Event event1;
    private Event event2;

    private List<Event> mockEvents = new LinkedList<>();

    @Before
    public void setup() {
        event1 = new Event();
        event2 = new Event();
        event1.setName("event1");
        event2.setName("event2");
        mockEvents.add(event1);
        mockEvents.add(event2);
    }

    @Test
    public void getGroupsTest() throws Exception {

        Mockito.when(eventService.getByNameSortedByDate(Mockito.anyString()))
                .thenReturn(mockEvents);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/events")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockEvents);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getGroupsWithParameterTest() throws Exception {

        Mockito.when(eventService.getByNameSortedByDate(Mockito.anyString()))
                .thenReturn(mockEvents);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/events?name=asdf")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockEvents);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
