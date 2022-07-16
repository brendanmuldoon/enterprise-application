package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;

public interface IStaffRepository {
    Iterable<StaffJpa> findAll();
}
