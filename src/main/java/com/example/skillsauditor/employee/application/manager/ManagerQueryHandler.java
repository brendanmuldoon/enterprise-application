package com.example.skillsauditor.employee.application.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import com.example.skillsauditor.employee.application.manager.mappers.ManagerJpaToDTOMapper;
import com.example.skillsauditor.employee.domain.manager.DTO.ManagerDTO;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.ui.manager.IManagerQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ManagerQueryHandler implements IManagerQueryHandler {

    private IManagerRepository managerRepository;
    @Override
    public Iterable<ManagerJpa> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<ManagerDTO> findByManagerId(String managerId) {
        Optional<ManagerJpa> response = managerRepository.findById(managerId);
        if(response.isPresent()) {
            return ManagerJpaToDTOMapper.convertManagerDetailsToDTO(response.get());
        }
        return Optional.empty();
    }
}
