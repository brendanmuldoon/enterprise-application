package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.domain.manager.DTO.ManagerDTO;

import java.util.Optional;

public interface IManagerQueryHandler {
    Iterable<?> findAll();

    Optional<ManagerDTO> findByManagerId(String managerId);

}
