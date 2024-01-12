package com.example.taskmanager.categories;
import org.springframework.stereotype.Component;
import com.example.taskmanager.categories.Category;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepositoryImpl implements CategoryRepository{
    
    public static final List<Category> categorys = new ArrayList<>(Arrays.asList(
            new Category("category559ffa0a-5bb7-4207-a14e-93090623dec1","Category1","description1",false),
            new Category("category559ffa0a-5bb7-4207-a14e-93090623dec2","Category2","description2",false),
            new Category("category559ffa0a-5bb7-4207-a14e-93090623dec3","Category3","description3",true)
    ));
    @Override
    public Collection<Category> findAll() {
        return categorys.stream().filter(category -> !category.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public Category save(Category dto) {
        Category createdCategory = new Category(dto.getUuid(),dto.getName(),dto.getDescription(),false);
        categorys.add(createdCategory);
        return createdCategory;
    }

    @Override
    public Category getByUUID(String uuid) {
        Category searched = null;
        for (Category category : categorys) {
            if (category.getUuid().equals(uuid)) {
                searched = category;
            }
        }
        return searched;
    }

    @Override
    public Category edit(Category categorySearched, CategoryDTO dto) {
        categorySearched.setName(dto.getName());
        categorySearched.setDescription(dto.getDescription());
        return categorySearched;
    }

    @Override
    public Category delete(Category categorySearched) {
        categorySearched.setDeleted(true);
        return categorySearched;
    }
}
