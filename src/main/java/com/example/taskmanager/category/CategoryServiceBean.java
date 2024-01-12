package com.example.taskmanager.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CategoryServiceBean implements CategoryService {

    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAll() {
        return categoryRepository
                .findAll()
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
        Category example1 = new Category(categoryDTO.getUuid());
        Optional<Category> optionalCategory = categoryRepository.findOne(Example.of(example1));

        // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.

        Category category = optionalCategory.get();
        category.setDescription(categoryDTO.getDescription());
        category.setName(categoryDTO.getName());

        categoryRepository.save(category);
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO getOne(String uuid) {
        Category category = getCategory(uuid);
        
        // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO delete(String uuid) {
        Category example1 = new Category(uuid);
        Optional<Category> optionalCategory = categoryRepository.findOne(Example.of(example1));

        // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.

        Category category = optionalCategory.get();
        categoryRepository.delete(category);

        return mapper.toDTO(category);
    }


    private Category getCategory(String uuid) {
        Category category = categoryRepository.findOneByUuid(uuid);
        // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.

        return category;
    }
}
