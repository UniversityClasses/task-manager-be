package com.example.taskmanager.category;

import com.example.taskmanager.category.*;
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

public class CategoryServiceBeanTest {

    @InjectMocks
    private CategoryServiceBean categoryService;

    @Mock
    private CategoryMapper categoryMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(new Category("Category 1","Category 1 description","uuid")));

        // Act
        categoryService.getAll();

        // Assert
        verify(categoryRepository, times(1)).findAll();
        verify(categoryMapper, times(1)).toDTO(any(Category.class));
    }

    @Test
    public void testCreate() {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO("uuid", "CategoryName", "CategoryDescription");
        Category category = new Category("uuid", "CategoryName", "CategoryDescription");

        when(categoryMapper.toModel(categoryDTO)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

        // Act
        CategoryDTO result = categoryService.create(categoryDTO);

        // Assert
        verify(categoryRepository, times(1)).save(category);
        verify(categoryMapper, times(1)).toDTO(category);
        assertEquals(categoryDTO, result);
    }

    @Test
    public void testEdit() {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO("uuid", "UpdatedCategoryName", "UpdatedCategoryDescription");
        Category existingCategory = new Category("uuid", "CategoryName", "CategoryDescription");

        when(categoryRepository.findOne(any())).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(existingCategory)).thenReturn(existingCategory);
        when(categoryMapper.toDTO(existingCategory)).thenReturn(categoryDTO);

        // Act
        CategoryDTO result = categoryService.edit(categoryDTO);

        // Assert
        verify(categoryRepository, times(1)).save(existingCategory);
        verify(categoryMapper, times(1)).toDTO(existingCategory);
        assertEquals(categoryDTO, result);
    }

    @Test
    public void testEditTaskNotFound() {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO("uuid", "UpdatedCategoryName", "UpdatedCategoryDescription");

        when(categoryRepository.findOne(any())).thenReturn(Optional.empty());

        // Act and Assert
        // TODO: Update for TaskNotFoundException
        assertThrows(RuntimeException.class, () -> categoryService.edit(categoryDTO));
    }

}
