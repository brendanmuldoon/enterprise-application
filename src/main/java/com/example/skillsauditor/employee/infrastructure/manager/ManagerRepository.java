package com.example.skillsauditor.employee.infrastructure.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ManagerRepository implements IManagerRepository {

    private CrudManagerRepository repository;

    @Override
    public Iterable<ManagerJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ManagerJpa> findById(String managerId) {
        return repository.findById(managerId);
    }
}
