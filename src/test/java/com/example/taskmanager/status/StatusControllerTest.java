package com.example.taskmanager.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class StatusControllerTest {

    @InjectMocks
    private StatusController statusController;

    @Mock
    private StatusService statusService;

    @Test
    public void testGetAll() {
        // Arrange
        List<StatusDTO> mockStatuskList = Arrays.asList(
                new StatusDTO("1","To Do"),
                new StatusDTO("2","In Progress")
        );
        Mockito.when(statusService.getAll()).thenReturn(mockStatuskList);

        // Act
        List<StatusDTO> result = statusController.getAll(null);

        // Assert
        Assertions.assertEquals(mockStatuskList, result);
    }

    @Test
    public void testCreate() {
        // Arrange
        StatusDTO inputStatusDTO = new StatusDTO("1","To Do");
        Mockito.when(statusService.create(inputStatusDTO)).thenReturn(inputStatusDTO);

        // Act
        StatusDTO result = statusController.create(inputStatusDTO);

        // Assert
        Assertions.assertEquals(inputStatusDTO, result);
    }

    @Test
    public void testGetOne() {
        // Arrange
        String statusUuid = "1";
        StatusDTO mockStatus = new StatusDTO("1","To Do");
        Mockito.when(statusService.getOne(statusUuid)).thenReturn(mockStatus);

        // Act
        ResponseEntity<StatusDTO> result = statusController.getOne(statusUuid);

        // Assert
        Assertions.assertEquals(mockStatus, result.getBody());
    }

    @Test
    public void testGetOneTaskNotFound() {
        // Arrange
        String statusUuid = "1";
        // TODO: Change for task not found exception
        Mockito.when(statusService.getOne(statusUuid)).thenThrow(new RuntimeException("Task not found"));

        // Act
        ResponseEntity<StatusDTO> responseEntity = statusController.getOne(statusUuid);

        // Assert
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue()); // Assuming you handle TaskNotFoundException with HTTP 404
        // You might want to include more assertions based on your actual exception handling logic
    }


    @Test
    public void testEdit() {
        // Arrange
        StatusDTO inputStatusDTO = new StatusDTO("1","To Do");
        Mockito.when(statusService.edit(inputStatusDTO)).thenReturn(inputStatusDTO);

        // Act
        StatusDTO result = statusController.edit(inputStatusDTO);

        // Assert
        Assertions.assertEquals(inputStatusDTO, result);
    }

    @Test
    public void testDelete() {
        // Arrange
        String statusUuid = "1";
        StatusDTO mockDeletedStatus = new StatusDTO("1","To Do");
        Mockito.when(statusService.delete(statusUuid)).thenReturn(mockDeletedStatus);

        // Act
        StatusDTO result = statusController.delete(statusUuid);

        // Assert
        Assertions.assertEquals(mockDeletedStatus, result);
    }
}
