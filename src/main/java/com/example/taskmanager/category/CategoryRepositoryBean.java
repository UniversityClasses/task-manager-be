package com.example.taskmanager.category;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryRepositoryBean implements CategoryRepository {

    private static final List<Category> categoryList = new ArrayList<>();

    static {
        categoryList.add(new Category("Category 1", "Category 1 description","559ffa0a-5bb7-4207-a14e-93090623dec8"));
        categoryList.add(new Category("Category 2", "Category 2 description","559ffa0a-5bb7-4207-a14e-93090623dec7"));
        categoryList.add(new Category("Category 3", "Category 3 description","559ffa0a-5bb7-4207-a14e-93090623dec9"));
    }
    @Override
    public Collection<Category> findAll() {
        return categoryList;
    }

    @Override
    public Category save(Category category) {
        return category;
    }

    @Override
    public Optional<Category> findOne(Example<Category> of) {
        return Optional.ofNullable(categoryList.get(0));
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Category findOneByUuid(String uuid) {
        return new Category("Category 1", "description", uuid);
    }
}
