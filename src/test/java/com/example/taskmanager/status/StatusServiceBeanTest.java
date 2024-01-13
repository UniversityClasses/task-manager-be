package com.example.taskmanager.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StatusServiceBeanTest {

    @InjectMocks
    private StatusServiceBean statusService;

    @Mock
    private StatusMapper statusMapper;

    @Mock
    private StatusRepository statusRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(statusRepository.findAll()).thenReturn(Collections.singletonList(new Status("To Do","1")));

        // Act
        statusService.getAll();

        // Assert
        verify(statusRepository, times(1)).findAll();
        verify(statusMapper, times(1)).toDTO(any(Status.class));
    }

    @Test
    public void testCreate() {
        // Arrange

        StatusDTO statusDTO = new StatusDTO("1","To Do");
        Status status = new Status("To Do","1");
        when(statusMapper.toModel(statusDTO)).thenReturn(status);
        when(statusRepository.save(status)).thenReturn(status);
        when(statusMapper.toDTO(status)).thenReturn(statusDTO);

        // Act
        StatusDTO result = statusService.create(statusDTO);

        // Assert
        verify(statusRepository, times(1)).save(status);
        verify(statusMapper, times(1)).toDTO(status);
        assertEquals(statusDTO, result);
    }

    @Test
    public void testEdit() {
        // Arrange

        StatusDTO statusDTO = new StatusDTO("1","To Do");
        Status existingStatus = new Status("To Do","1");

        when(statusRepository.findOne(any())).thenReturn(Optional.of(existingStatus));
        when(statusRepository.save(existingStatus)).thenReturn(existingStatus);
        when(statusMapper.toDTO(existingStatus)).thenReturn(statusDTO);

        // Act
        StatusDTO result = statusService.edit(statusDTO);

        // Assert
        verify(statusRepository, times(1)).save(existingStatus);
        verify(statusMapper, times(1)).toDTO(existingStatus);
        assertEquals(statusDTO, result);
    }

    @Test
    public void testEditTaskNotFound() {
        // Arrange
        StatusDTO statusDTO = new StatusDTO("1","To Do");

        when(statusRepository.findOne(any())).thenReturn(Optional.empty());

        // Act and Assert
        // TODO: Update for TaskNotFoundException
        assertThrows(RuntimeException.class, () -> statusService.edit(statusDTO));
    }

}
