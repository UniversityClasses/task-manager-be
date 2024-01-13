package com.example.taskmanager.status;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> getStatusByUuid(UUID uuid);
}
