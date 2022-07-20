package com.example.skillsauditor.employee.application.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.ui.manager.IManagerQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ManagerQueryHandler implements IManagerQueryHandler {

    private IManagerRepository managerRepository;
    @Override
    public Iterable<ManagerJpa> findAll() {
        return managerRepository.findAll();
    }
}
