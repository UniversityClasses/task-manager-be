package com.example.taskmanager.status;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class StatusRepositoryBean implements StatusRepository {

    private static final List<Status> statusList = new ArrayList<>();

    static {
        statusList.add(new Status("To Do",  "559ffa0a-5bb7-4207-a14e-93090623dec8"));
        statusList.add(new Status("In Progress",  "559ffa0a-5bb7-4207-a14e-93090623dec7"));
        statusList.add(new Status("Done",  "559ffa0a-5bb7-4207-a14e-93090623dec9"));
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
        return new Status("Review", uuid);
    }
}
