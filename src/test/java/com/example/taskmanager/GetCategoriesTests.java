package com.example.taskmanager;

import com.example.taskmanager.category.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class GetCategoriesTests {
    private static final List<Category> categoryList = new ArrayList<>();

    static {
        categoryList.add(new Category("Category 1", "Category 1 description", UUID.randomUUID().toString()));
        categoryList.add(new Category("Category 2", "Category 2 description", UUID.randomUUID().toString()));
        categoryList.add(new Category("Category 2", "Category 3 description", UUID.randomUUID().toString()));
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/categories"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))  // Check if the array has three elements
                .andExpect(jsonPath("$[0].uuid", is("559ffa0a-5bb7-4207-a14e-93090623dec8")))  // Check the first element's id
                .andExpect(jsonPath("$[0].name", is("Category 1")))  // Check the first element's name
                .andExpect(jsonPath("$[1].uuid", is("559ffa0a-5bb7-4207-a14e-93090623dec7")))  // Check the second element's id
                .andExpect(jsonPath("$[1].name", is("Category 2")))
                .andExpect(MockMvcResultMatchers.content().string("[{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec8\",\"name\":\"Category 1\",\"description\":\"Category 1 description\"},{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec7\",\"name\":\"Category 2\",\"description\":\"Category 2 description\"},{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec9\",\"name\":\"Category 3\",\"description\":\"Category 3 description\"}]"));
    }
}
