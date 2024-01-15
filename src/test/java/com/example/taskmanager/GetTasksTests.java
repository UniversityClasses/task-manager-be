package com.example.taskmanager;

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
//    private static final List<Task> taskList = new ArrayList<>();
//
//    static {
//        taskList.add(new Task("task 1", "task 1 description", "cat 1", "status 1", UUID.randomUUID().toString()));
//        taskList.add(new Task("task 2", "task 2 description", "cat 1", "status 2", UUID.randomUUID().toString()));
//        taskList.add(new Task("task 3", "task 3 description", "cat 1", "status 3", UUID.randomUUID().toString()));
//    }
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testControllerEndpoint() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))  // Check if the array has three elements
//                .andExpect(jsonPath("$[0].uuid", is("559ffa0a-5bb7-4207-a14e-93090623dec8")))  // Check the first element's id
//                .andExpect(jsonPath("$[0].name", is("task 1")))  // Check the first element's name
//                .andExpect(jsonPath("$[1].uuid", is("559ffa0a-5bb7-4207-a14e-93090623dec7")))  // Check the second element's id
//                .andExpect(jsonPath("$[1].name", is("task 2")))
//                .andExpect(MockMvcResultMatchers.content().string("[{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec8\",\"name\":\"task 1\",\"description\":\"task 1 description\",\"category\":\"cat 1\",\"status\":\"status 1\"},{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec7\",\"name\":\"task 2\",\"description\":\"task 2 description\",\"category\":\"cat 1\",\"status\":\"status 2\"},{\"uuid\":\"559ffa0a-5bb7-4207-a14e-93090623dec9\",\"name\":\"task 3\",\"description\":\"task 3 description\",\"category\":\"cat 1\",\"status\":\"status 3\"}]"));
//    }
}
