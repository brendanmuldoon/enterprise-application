package com.example.skillsauditor.employee.infrastructure.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StaffRepository implements IStaffRepository {

    private CrudStaffRepository repository;
    @Override
    public Iterable<StaffJpa> findAll() {
        return repository.findAll();
    }
}
