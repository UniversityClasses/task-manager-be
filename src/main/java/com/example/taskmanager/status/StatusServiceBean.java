package com.example.taskmanager.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StatusServiceBean implements StatusService {

    @Autowired
    private StatusMapper mapper;

    @Autowired
    private StatusRepository statusRepository;

    public List<StatusDTO> getAll() {
        return statusRepository
                .findAll()
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
        Status example1 = new Status(statusDTO.getUuid());
        Optional<Status> optionalStatus = statusRepository.findOne(Example.of(example1));

        // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.

        Status status = optionalStatus.get();
        status.setName(statusDTO.getName());

        statusRepository.save(status);
        return mapper.toDTO(status);
    }

    @Override
    public StatusDTO getOne(String uuid) {
        Status status = getStatus(uuid);
        
        // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.


        return mapper.toDTO(status);
    }

    @Override
    public StatusDTO delete(String uuid) {
        Status example1 = new Status(uuid);
        Optional<Status> optionalStatus = statusRepository.findOne(Example.of(example1));

        // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.

        Status status = optionalStatus.get();
        statusRepository.delete(status);

        return mapper.toDTO(status);
    }


    private Status getStatus(String uuid) {
        Status status = statusRepository.findOneByUuid(uuid);
        // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.

        return status;
    }
}
