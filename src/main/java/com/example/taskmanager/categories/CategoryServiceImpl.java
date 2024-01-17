package com.example.taskmanager.categories;

import com.example.taskmanager.exceptions.CategoryNotFoundExeption;
import com.example.taskmanager.exceptions.StateNotFoundExeption;
import com.example.taskmanager.status.State;
import com.example.taskmanager.status.StateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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
        Category categorySearched = null;//categoryRepository.findOne(Example.of());
        if (categorySearched != null)
            return mapper.toDTO(categorySearched);
        else return null;
    }

    @Override
    public CategoryDTO edit(CategoryDTO dto) {
        Category categorySearched = null;//categoryRepository.getByUUID(dto.getUuid());
        if (categorySearched != null){
            Category updateCategory = null; //categoryRepository.edit(categorySearched,dto);
            return mapper.toDTO(updateCategory);
        }
        else return null;
    }

    @Override
    public CategoryDTO delete(String uuid) {
        Optional<Category> optionalCategory = null;//Optional.ofNullable(categoryRepository.getByUUID(uuid));
        Category stateSearched = optionalCategory.orElseThrow(() -> new CategoryNotFoundExeption("State Not Found with UUID: " + uuid));
        Category categoryDeleted = null;//categoryRepository.delete(stateSearched);
        return mapper.toDTO(categoryDeleted);
    }
}
