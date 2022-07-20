package com.example.skillsauditor.employee.application.manager.interfaces;

import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;

public interface IManagerRepository {


    Iterable<ManagerJpa> findAll();
}
