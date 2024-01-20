package com.example.taskmanager.EjemploOneToOne.Passport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PassportRepository extends JpaRepository<Passport,Long> {
    Optional<Passport> findPassportByUuid(UUID uuid);
}
