package com.example.skillsauditor.employee.application.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.ui.staff.IStaffQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StaffQueryHandler implements IStaffQueryHandler {

    private IStaffRepository staffRepository;

    @Override
    public Iterable<StaffJpa> findAll() {
        return staffRepository.findAll();
    }
}
