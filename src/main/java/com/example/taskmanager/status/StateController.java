package com.example.taskmanager.status;
import com.example.taskmanager.exceptions.CategoryNotFoundExeption;
import com.example.taskmanager.exceptions.StateNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try{
            StateDTO stateDtoSearched = stateService.getOne(uuid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(stateDtoSearched);
        }
        catch(StateNotFoundExeption exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PutMapping
    public ResponseEntity<StateDTO> edit(@RequestBody StateDTO dto) {
        try{
            StateDTO stateDtoEdited = stateService.edit(dto);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(stateDtoEdited);
        }
        catch(StateNotFoundExeption exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<StateDTO> delete(@PathVariable  String uuid) {
        try{
            StateDTO stateDtoDeleted = stateService.delete(uuid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(stateDtoDeleted);
        }
        catch(StateNotFoundExeption exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
