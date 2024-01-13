package com.example.taskmanager;

import com.example.taskmanager.status.Status;
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
public class GetStatusTests {
    private static final List<Status> statusList = new ArrayList<>();



    static {
        statusList.add(new Status("To Do",UUID.randomUUID().toString()));
        statusList.add(new Status("In Progress",UUID.randomUUID().toString()));
        statusList.add(new Status("Review", UUID.randomUUID().toString()));
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/statuses"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))  // Check if the array has three elements
                .andExpect(jsonPath("$[0].uuid", is("de8b130c-db9d-42c9-a257-abe6bca1f0d1")))  // Check the first element's id
                .andExpect(jsonPath("$[0].name", is("To Do")))  // Check the first element's name
                .andExpect(jsonPath("$[1].uuid", is("7739b20c-dbcb-423d-aed6-b702cc175b37")))  // Check the second element's id
                .andExpect(jsonPath("$[1].name", is("In Progress")))
                .andExpect(MockMvcResultMatchers.content().string("[{\"uuid\":\"de8b130c-db9d-42c9-a257-abe6bca1f0d1\",\"name\":\"To Do\"},{\"uuid\":\"7739b20c-dbcb-423d-aed6-b702cc175b37\",\"name\":\"In Progress\"},{\"uuid\":\"6b25270d-3b2f-4a0c-acd5-0b4eae9936e0\",\"name\":\"Review\"}]"));
    }
}
