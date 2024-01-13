package com.example.taskmanager.category;

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
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Test
    public void testGetAll() {
        // Arrange
        List<CategoryDTO> mockCategoryList = Arrays.asList(
                new CategoryDTO("1", "New Category 1", "description"),
                new CategoryDTO("2", "New Category 2", "description")
        );
        Mockito.when(categoryService.getAll()).thenReturn(mockCategoryList);

        // Act
        List<CategoryDTO> result = categoryController.getAll(null);

        // Assert
        Assertions.assertEquals(mockCategoryList, result);
    }

    @Test
    public void testCreate() {
        // Arrange
        CategoryDTO inputCategoryDTO = new CategoryDTO("uuid","Category 1","Category");
        Mockito.when(categoryService.create(inputCategoryDTO)).thenReturn(inputCategoryDTO);

        // Act
        CategoryDTO result = categoryController.create(inputCategoryDTO);

        // Assert
        Assertions.assertEquals(inputCategoryDTO, result);
    }

    @Test
    public void testGetOne() {
        // Arrange
        String categoryUuid = "1";
        CategoryDTO mockCategory = new CategoryDTO(categoryUuid, "New Category", "description");
        Mockito.when(categoryService.getOne(categoryUuid)).thenReturn(mockCategory);

        // Act
        ResponseEntity<CategoryDTO> result = categoryController.getOne(categoryUuid);

        // Assert
        Assertions.assertEquals(mockCategory, result.getBody());
    }

    @Test
    public void testGetOneTaskNotFound() {
        // Arrange
        String categorykUuid = "1";
        // TODO: Change for task not found exception
        Mockito.when(categoryService.getOne(categorykUuid)).thenThrow(new RuntimeException("Task not found"));

        // Act
        ResponseEntity<CategoryDTO> responseEntity = categoryController.getOne(categorykUuid);

        // Assert
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue()); // Assuming you handle TaskNotFoundException with HTTP 404
        // You might want to include more assertions based on your actual exception handling logic
    }


    @Test
    public void testEdit() {
        // Arrange
        CategoryDTO inputCategoryDTO = new CategoryDTO("1", "Updated Category 1", "description");
        Mockito.when(categoryService.edit(inputCategoryDTO)).thenReturn(inputCategoryDTO);

        // Act
        CategoryDTO result = categoryController.edit(inputCategoryDTO);

        // Assert
        Assertions.assertEquals(inputCategoryDTO, result);
    }

    @Test
    public void testDelete() {
        // Arrange
        String categoryUuid = "1";
        CategoryDTO mockDeletedCategory = new CategoryDTO(categoryUuid, "Deleted Category", "description");
        Mockito.when(categoryService.delete(categoryUuid)).thenReturn(mockDeletedCategory);

        // Act
        CategoryDTO result = categoryService.delete(categoryUuid);

        // Assert
        Assertions.assertEquals(mockDeletedCategory, result);
    }
}
