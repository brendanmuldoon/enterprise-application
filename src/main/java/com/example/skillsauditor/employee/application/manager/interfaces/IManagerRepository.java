package com.example.skillsauditor.employee.application.manager.interfaces;

import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;

import java.util.Optional;

public interface IManagerRepository {


    Iterable<ManagerJpa> findAll();

    Optional<ManagerJpa> findById(String managerId);

    void save(ManagerJpa managerJpa);
}
