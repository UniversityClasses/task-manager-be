package com.example.taskmanager.status;

import com.example.taskmanager.exceptions.StatusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class StatusServiceBean implements StatusService {

    @Autowired
    private StatusMapper mapper;


    @Autowired
    private StatusRepository statusRepository;


    @Override
    public List<StatusDTO> getAll() {
        List<Status> statuses = statusRepository.findAll();
        return statuses
                .stream()
                .map(status -> mapper.toDTO(status))
                .collect(Collectors.toList());
    }

    @Override
    public StatusDTO create(StatusDTO dto) {

        Status status = mapper.toModel(dto);
        Status savedStatus = statusRepository.save(status);
        return mapper.toDTO(savedStatus);
    }

    @Override
    public StatusDTO edit(StatusDTO statusDTO) {
        Optional<Status> optionalStatus = statusRepository.getStatusByUuid(statusDTO.getUuid());

        if (optionalStatus.isEmpty()) {
            throw new StatusNotFoundException(statusDTO.getUuid().toString());
        }

        Status status = optionalStatus.get();
        status.setDescription(statusDTO.getDescription());
        status.setName(statusDTO.getName());


        statusRepository.save(status);
        return mapper.toDTO(status);
    }

    @Override
    public StatusDTO getOne(UUID uuid) {
        Status status = new Status(uuid);
        Optional<Status> status1 = statusRepository.findOne(Example.of(status));

        // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.

        return mapper.toDTO(status1.get());
    }

    @Override
    public StatusDTO delete(UUID uuid) {
        Optional<Status> optionalStatus = statusRepository.getStatusByUuid(uuid);

        // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.

        Status status = optionalStatus.get();
        statusRepository.delete(status);
        return mapper.toDTO(status);
    }
}
