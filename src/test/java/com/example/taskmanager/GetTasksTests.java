package com.example.taskmanager;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.tasks.Task;
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
public class GetTasksTests {
    private static final List<Task> taskList = new ArrayList<>();



    static {
        taskList.add(new Task("task 1", "task 1 description", new Category("Category 1","Category 1 Description","1"), new Status("To Do","1"), UUID.randomUUID().toString()));
        taskList.add(new Task("task 2", "task 2 description", new Category("Category 2","Category 2 Description","2"), new Status("To Do","2"), UUID.randomUUID().toString()));
        taskList.add(new Task("task 3", "task 3 description", new Category("Category 3","Category 2 Description","3"), new Status("To Do","3"), UUID.randomUUID().toString()));
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))  // Check if the array has three elements
                .andExpect(jsonPath("$[0].uuid", is("559ffa0a-5bb7-4207-a14e-93090623det8")))  // Check the first element's id
                .andExpect(jsonPath("$[0].name", is("task 1")))  // Check the first element's name
                .andExpect(jsonPath("$[1].uuid", is("559ffa0a-5bb7-4207-a14e-93090623det7")))  // Check the second element's id
                .andExpect(jsonPath("$[1].name", is("task 2")))
                .andExpect(MockMvcResultMatchers.content().string("[{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623det8\",\"name\":\"task 1\",\"description\":\"task 1 description\",\"category\":{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec7\",\"name\":\"Category 1\",\"description\":\"Cate 1\"},\"status\":{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623des7\",\"name\":\"To Do\"}},{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623det7\",\"name\":\"task 2\",\"description\":\"task 2 description\",\"category\":{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec7\",\"name\":\"Category 1\",\"description\":\"Cate 1\"},\"status\":{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623des8\",\"name\":\"To Do\"}},{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623det9\",\"name\":\"task 3\",\"description\":\"task 3 description\",\"category\":{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec7\",\"name\":\"Category 1\",\"description\":\"Cate 1\"},\"status\":{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623des9\",\"name\":\"To Do\"}}]"));
    }
}
