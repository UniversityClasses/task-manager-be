package com.example.taskmanager.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<StatusDTO> getAll() {
        return statusService.getAll();
    }

    @PostMapping
    public StatusDTO create(@Validated(StatusDTO.CreateValidationGroup.class) @RequestBody StatusDTO dto) {
        return statusService.create(dto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<StatusDTO> getOne(@PathVariable String uuid) {
        try {
            StatusDTO status = statusService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(status);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PutMapping
    public StatusDTO edit(@Validated(StatusDTO.UpdateValidationGroup.class)  @RequestBody StatusDTO dto) {
        return statusService.edit(dto);
    }

    @DeleteMapping("/{uuid}")
    public StatusDTO delete(@PathVariable String uuid) {
        return statusService.delete(UUID.fromString(uuid));
    }
}
