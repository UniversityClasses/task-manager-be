package com.example.taskmanager.status;
import com.example.taskmanager.exceptions.status.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public StateDTO create(@Validated(StateDTO.CreateValidationGroup.class) @RequestBody StateDTO dto){
        return stateService.create(dto);
    }


    @GetMapping("/{uuid}")
    public StateDTO getOne(@PathVariable String uuid) {
            return stateService.getOne(UUID.fromString(uuid));
    }

    @PutMapping
    public ResponseEntity<StateDTO> edit(@Validated(StateDTO.UpdateValidationGroup.class) @RequestBody StateDTO dto) {
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
    public StateDTO delete(@PathVariable  String uuid) {
            return stateService.delete(UUID.fromString(uuid));
    }
}
