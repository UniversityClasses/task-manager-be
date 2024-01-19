package com.example.taskmanager.categories;

import com.example.taskmanager.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll(@RequestParam(value = "taskId", required = false) List<String> taskIdList){
        return categoryService.getAll(taskIdList);
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto){
        return categoryService.create(dto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> getOne(@PathVariable String uuid) {
        try{
            CategoryDTO categoryDtoSearched = categoryService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryDtoSearched);
        }
        catch(CategoryNotFoundException exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> edit(@RequestBody CategoryDTO dto) {
        try{
            CategoryDTO categoryDtoEdited = categoryService.edit(dto);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryDtoEdited);
        }
        catch(CategoryNotFoundException exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable  String uuid) {
        try{
            CategoryDTO categoryDtoDeleted = categoryService.delete(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryDtoDeleted);
        }
        catch(CategoryNotFoundException exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
