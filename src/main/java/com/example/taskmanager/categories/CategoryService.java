package com.example.taskmanager.categories;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface CategoryService {
    public List<CategoryDTO> getAll(List<String> taskIdList);

    public CategoryDTO create(CategoryDTO dto);

    public CategoryDTO getOne(UUID uuid);

    public CategoryDTO edit(CategoryDTO dto);

    public CategoryDTO delete(UUID uuid);
}
