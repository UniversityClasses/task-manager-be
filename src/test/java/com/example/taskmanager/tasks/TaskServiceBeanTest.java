package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceBeanTest {

    @InjectMocks
    private TaskServiceBean taskService;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        //when(taskRepository.findAll()).thenReturn(Collections.singletonList(new Task("uuid", "TaskName", "TaskDescription", "Category", "Status")));
        Category category1 = new Category("Category 1","Category 1 description","1");
        Status status1 = new Status("To Do","1");
        when(taskRepository.findAll()).thenReturn(Collections.singletonList(new Task("uuid", "TaskName", category1, status1, "Status")));

        // Act
        taskService.getAll();

        // Assert
        verify(taskRepository, times(1)).findAll();
        verify(taskMapper, times(1)).toDTO(any(Task.class));
    }

    @Test
    public void testCreate() {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO("1","Category 1","Category 1 Description");
        StatusDTO statusDTO = new StatusDTO("1","To Do");
        TaskDTO taskDTO = new TaskDTO("uuid", "TaskName", "TaskDescription", categoryDTO, statusDTO);
        Category category = new Category("Category 1","Category 1 Description","1");
        Status status = new Status("To Do","1");
        Task task = new Task("uuid", "TaskName", category, status, "Status");

        when(taskMapper.toModel(taskDTO)).thenReturn(task);
        when(taskRepository.save(task)).thenReturn(task);
        when(taskMapper.toDTO(task)).thenReturn(taskDTO);

        // Act
        TaskDTO result = taskService.create(taskDTO);

        // Assert
        verify(taskRepository, times(1)).save(task);
        verify(taskMapper, times(1)).toDTO(task);
        assertEquals(taskDTO, result);
    }

    @Test
    public void testEdit() {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO("1","Category 1","Category 1 Description");
        StatusDTO statusDTO = new StatusDTO("1","To Do");
        TaskDTO taskDTO = new TaskDTO("uuid", "UpdatedTaskName", "UpdatedTaskDescription", categoryDTO, statusDTO);
        Category category = new Category("Category 1","Category 1 Description","1");
        Status status = new Status("To Do","1");
        Task existingTask = new Task("uuid", "TaskName", category, status, "Status");

        when(taskRepository.findOne(any())).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(existingTask);
        when(taskMapper.toDTO(existingTask)).thenReturn(taskDTO);

        // Act
        TaskDTO result = taskService.edit(taskDTO);

        // Assert
        verify(taskRepository, times(1)).save(existingTask);
        verify(taskMapper, times(1)).toDTO(existingTask);
        assertEquals(taskDTO, result);
    }

    @Test
    public void testEditTaskNotFound() {
        // Arrange
        TaskDTO taskDTO = new TaskDTO("uuid", "UpdatedTaskName", "UpdatedTaskDescription", null, null);

        when(taskRepository.findOne(any())).thenReturn(Optional.empty());

        // Act and Assert
        // TODO: Update for TaskNotFoundException
        assertThrows(RuntimeException.class, () -> taskService.edit(taskDTO));
    }

}
