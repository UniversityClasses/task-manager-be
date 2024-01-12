package com.example.taskmanager.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll(){
        return categoryService.getAll();
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto){
        return categoryService.create(dto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> getOne(@PathVariable String uuid) {
        CategoryDTO categoryDtoSearched = categoryService.getOne(uuid);
        if (categoryDtoSearched != null) {
            return ResponseEntity.ok(categoryDtoSearched);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> edit(@RequestBody CategoryDTO dto) {
        CategoryDTO categoryDtoEdited = categoryService.edit(dto);
        if (categoryDtoEdited != null) {
            return ResponseEntity.ok(categoryDtoEdited);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable  String uuid) {
        CategoryDTO categoryDtoDeleted = categoryService.delete(uuid);
        if (categoryDtoDeleted != null) {
            return ResponseEntity.ok(categoryDtoDeleted);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
