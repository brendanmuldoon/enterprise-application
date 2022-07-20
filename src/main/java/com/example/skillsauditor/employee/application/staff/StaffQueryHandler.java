package com.example.skillsauditor.employee.application.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import com.example.skillsauditor.employee.application.staff.mappers.StaffJpaToDTOMapper;
import com.example.skillsauditor.employee.domain.staff.DTO.StaffDTO;
import com.example.skillsauditor.employee.domain.staff.DTO.StaffSkillDTO;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.ui.staff.IStaffQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StaffQueryHandler implements IStaffQueryHandler {

    private IStaffRepository staffRepository;

    @Override
    public Iterable<StaffJpa> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<StaffDTO> findByStaffId(String staffId) {
        Optional<StaffJpa> response = staffRepository.findById(staffId);
        if(response.isPresent()) {
            return StaffJpaToDTOMapper.convertStaffDetailsToDTO(response.get());
        }
        return Optional.empty();
    }

    @Override
    public List<StaffSkillDTO> findSkillsByStaffId(String staffId) {
        Optional<StaffJpa> response = staffRepository.findById(staffId);
        if (response.isPresent()) {
            return StaffJpaToDTOMapper.convertStaffSkillsToDTO(response.get());
        }
        return new ArrayList<>();
    }
}
