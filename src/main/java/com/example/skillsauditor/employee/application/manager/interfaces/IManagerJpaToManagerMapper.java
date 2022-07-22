package com.example.skillsauditor.employee.application.manager.interfaces;

import com.example.skillsauditor.employee.domain.manager.Manager;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;

public interface IManagerJpaToManagerMapper {
    Manager map(ManagerJpa managerJpa);
}
