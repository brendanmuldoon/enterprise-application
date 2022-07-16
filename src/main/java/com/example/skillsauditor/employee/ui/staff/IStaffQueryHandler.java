package com.example.skillsauditor.employee.ui.staff;

import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;

public interface IStaffQueryHandler {

    Iterable<StaffJpa> findAll();
}
