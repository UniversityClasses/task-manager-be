package com.example.taskmanager.status;

import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.Optional;

public interface StatusRepository {
    Collection<Status> findAll();

    Status save(Status status);

    Optional<Status> findOne(Example<Status> of);

    void delete(Status status);

    Status findOneByUuid(String uuid);
}
