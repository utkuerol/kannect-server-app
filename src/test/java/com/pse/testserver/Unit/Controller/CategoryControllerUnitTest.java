package com.pse.testserver.Unit.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.entities.Category;
import com.pse.testserver.service.CategoryService;
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
public class CategoryControllerUnitTest {

    List<Category> mockCategories = new LinkedList<>();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CategoryService categoryService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Category category1;
    private Category category2;

    @Before
    public void setup() {
        category1 = new Category();
        category2 = new Category();
        category1.setName("bars");
        category2.setName("clubs");
        mockCategories.add(category1);
        mockCategories.add(category2);
    }

    @Test
    public void getCategoriesTest() throws Exception {
        Mockito.when(categoryService.getAllCategories())
                .thenReturn(mockCategories);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andReturn();

        String expected = objectMapper.writeValueAsString(mockCategories);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
