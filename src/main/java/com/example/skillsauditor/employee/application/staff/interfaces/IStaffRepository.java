package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;

import java.util.List;
import java.util.Optional;

public interface IStaffRepository {
    Iterable<StaffJpa> findAll();

    Optional<StaffJpa> findById(String staffId);

    StaffJpa save(StaffJpa staffJpa);

    void delete(StaffJpa staffJpa);
}
