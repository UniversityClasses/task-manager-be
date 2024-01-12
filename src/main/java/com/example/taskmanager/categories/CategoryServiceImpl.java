package com.example.taskmanager.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAll() {
        return  categoryRepository
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
    public CategoryDTO getOne(String uuid) {
        Category categorySearched = categoryRepository.getByUUID(uuid);
        if (categorySearched != null)
            return mapper.toDTO(categorySearched);
        else return null;
    }

    @Override
    public CategoryDTO edit(CategoryDTO dto) {
        Category categorySearched = categoryRepository.getByUUID(dto.getUuid());
        if (categorySearched != null){
            Category updateCategory = categoryRepository.edit(categorySearched,dto);
            return mapper.toDTO(updateCategory);
        }
        else return null;
    }

    @Override
    public CategoryDTO delete(String uuid) {
        Category categorySearched = categoryRepository.getByUUID(uuid);
        if (categorySearched != null){
            Category deletedCategory = categoryRepository.delete(categorySearched);
            return mapper.toDTO(deletedCategory);
        }
        else return null;
    }
}
