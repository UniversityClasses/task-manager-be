package com.example.taskmanager.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    public List<StateDTO> getAll(){
        return stateService.getAll();
    }

    @PostMapping
    public StateDTO create(@RequestBody StateDTO dto){
        return stateService.create(dto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<StateDTO> getOne(@PathVariable String uuid) {
        StateDTO categoryDtoSearched = stateService.getOne(uuid);
        if (categoryDtoSearched != null) {
            return ResponseEntity.ok(categoryDtoSearched);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<StateDTO> edit(@RequestBody StateDTO dto) {
        StateDTO categoryDtoEdited = stateService.edit(dto);
        if (categoryDtoEdited != null) {
            return ResponseEntity.ok(categoryDtoEdited);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<StateDTO> delete(@PathVariable  String uuid) {
        StateDTO categoryDtoDeleted = stateService.delete(uuid);
        if (categoryDtoDeleted != null) {
            return ResponseEntity.ok(categoryDtoDeleted);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
