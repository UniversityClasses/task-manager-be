package com.example.taskmanager.category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAll();

    CategoryDTO create(CategoryDTO dto);

    CategoryDTO edit(CategoryDTO dto);

    CategoryDTO getOne(String uuid);

    CategoryDTO delete(String uuid);
}
