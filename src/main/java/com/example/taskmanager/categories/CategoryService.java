package com.example.taskmanager.categories;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryService {
    public List<CategoryDTO> getAll();

    public CategoryDTO create(CategoryDTO dto);

    public CategoryDTO getOne(String uuid);

    public CategoryDTO edit(CategoryDTO dto);

    public CategoryDTO delete(String uuid);
}
