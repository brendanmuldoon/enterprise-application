package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.domain.manager.DTO.ManagerDTO;
import com.example.skillsauditor.employee.domain.manager.DTO.ManagerTeamDTO;

import java.util.List;
import java.util.Optional;

public interface IManagerQueryHandler {
    Iterable<?> findAll();

    Optional<ManagerDTO> findByManagerId(String managerId);

    List<ManagerTeamDTO> findTeamByManagerId(String managerId);
}
