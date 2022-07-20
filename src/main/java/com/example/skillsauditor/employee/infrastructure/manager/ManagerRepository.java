package com.example.skillsauditor.employee.infrastructure.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManagerRepository implements IManagerRepository {

    private CrudManagerRepository repository;

    @Override
    public Iterable<ManagerJpa> findAll() {
        return repository.findAll();
    }
}
