package com.example.taskmanager.category;

import com.example.taskmanager.category.CategoryDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryDTO> getAll();

    CategoryDTO create(CategoryDTO dto);

    CategoryDTO edit(CategoryDTO dto);

    CategoryDTO getOne(UUID uuid);

    CategoryDTO delete(UUID uuid);

    List<CategoryDTO> searchByNameDescrition(String palabra);
}
