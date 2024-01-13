package com.example.taskmanager.status;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StatusRepositoryBean implements StatusRepository {

    private static final List<Status> statusList = new ArrayList<>();

    static {
        statusList.add(new Status("To Do", UUID.randomUUID().toString()));
        statusList.add(new Status("In Progress",UUID.randomUUID().toString()));
        statusList.add(new Status("Review",UUID.randomUUID().toString()));
    }
    @Override
    public Collection<Status> findAll() {
        return statusList;
    }

    @Override
    public Status save(Status status) {
        return status;
    }

    @Override
    public Optional<Status> findOne(Example<Status> of) {
        return Optional.ofNullable(statusList.get(0));
    }

    @Override
    public void delete(Status status) {

    }

    @Override
    public Status findOneByUuid(String uuid) {
        return new Status("To Do", uuid);
    }
}
