package com.example.skillsauditor.employee.infrastructure.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StaffRepository implements IStaffRepository {

    private CrudStaffRepository repository;
    @Override
    public Iterable<StaffJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<StaffJpa> findById(String staffId) {
        return repository.findById(staffId);
    }
}
