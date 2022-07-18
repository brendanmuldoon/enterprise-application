package com.example.skillsauditor.employee.ui.staff;

import com.example.skillsauditor.employee.domain.staff.DTO.StaffDTO;
import com.example.skillsauditor.employee.domain.staff.DTO.StaffSkillDTO;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;

import java.util.List;
import java.util.Optional;

public interface IStaffQueryHandler {

    Iterable<StaffJpa> findAll();

    Optional<StaffDTO> findByStaffId(String staffId);

    List<StaffSkillDTO> findSkillsByStaffId(String staffId);
}
