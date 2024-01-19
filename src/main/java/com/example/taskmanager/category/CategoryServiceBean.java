package com.example.taskmanager.category;

import com.example.taskmanager.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CategoryServiceBean implements CategoryService {

    @Autowired
    private CategoryMapper mapper;


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(category -> mapper.toDTO(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {

        Category category = mapper.toModel(dto);
        Category savedCategory = categoryRepository.save(category);
        return mapper.toDTO(savedCategory);
    }

    @Override
    public CategoryDTO edit(CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryRepository.getCategoryByUuid(categoryDTO.getUuid());

        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException(categoryDTO.getUuid().toString());
        }

        Category category = optionalCategory.get();
        category.setDescription(categoryDTO.getDescription());
        category.setName(categoryDTO.getName());


        categoryRepository.save(category);
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO getOne(UUID uuid) {
        Category category = new Category(uuid);
        Optional<Category> category1 = categoryRepository.findOne(Example.of(category));

//        Optional<Task> task = taskRepository.getTaskByUuid(uuid);
        
        // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.


        return mapper.toDTO(category1.get());
    }

    @Override
    public CategoryDTO delete(UUID uuid) {
        Optional<Category> optionalCategory = categoryRepository.getCategoryByUuid(uuid);

        // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.

        Category category = optionalCategory.get();
        categoryRepository.delete(category);
        return mapper.toDTO(category);
    }
}
