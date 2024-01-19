package com.example.taskmanager.status;
import com.example.taskmanager.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    public List<StateDTO> getAll(@RequestParam(value = "taskId", required = false) List<String> taskIdList){
        return stateService.getAll(taskIdList);
    }

    @PostMapping
    public StateDTO create(@RequestBody StateDTO dto){
        return stateService.create(dto);
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<StateDTO> getOne(@PathVariable String uuid) {
        try{
            StateDTO stateDtoSearched = stateService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(stateDtoSearched);
        }
        catch(StateNotFoundException exeption){
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
        catch(StateNotFoundException exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<StateDTO> delete(@PathVariable  String uuid) {
        try{
            StateDTO stateDtoDeleted = stateService.delete(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(stateDtoDeleted);
        }
        catch(StateNotFoundException exeption){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
