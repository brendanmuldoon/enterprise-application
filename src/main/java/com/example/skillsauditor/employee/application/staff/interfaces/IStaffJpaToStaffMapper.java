package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.domain.staff.Staff;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;

public interface IStaffJpaToStaffMapper {

    Staff map(StaffJpa staffJpa);
}
