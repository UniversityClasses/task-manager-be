package com.example.taskmanager.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> getStatusByUuid(UUID uuid);
}
