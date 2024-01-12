package com.example.taskmanager.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll(@RequestParam(value = "categoryId", required = false) List<String> categoryIdList) {
        return categoryService.getAll();
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return categoryService.create(dto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> getOne(@PathVariable String uuid) {
        try {
            CategoryDTO category = categoryService.getOne(uuid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(category);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PutMapping
    public CategoryDTO edit(@RequestBody CategoryDTO dto) {
        return categoryService.edit(dto);
    }

    @DeleteMapping("/{uuid}")
    public CategoryDTO delete(@PathVariable String uuid) {
        return categoryService.delete(uuid);
    }
}
