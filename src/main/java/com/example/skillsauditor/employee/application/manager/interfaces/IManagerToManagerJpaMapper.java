package com.example.skillsauditor.employee.application.manager.interfaces;

import com.example.skillsauditor.employee.domain.manager.Manager;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;

public interface IManagerToManagerJpaMapper {
    ManagerJpa map(Manager manager);
}
