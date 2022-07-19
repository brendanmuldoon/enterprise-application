package com.example.skillsauditor.employee.application.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffJpaToStaffMapper;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffSkillRepository;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffToStaffJpaMapper;
import com.example.skillsauditor.employee.domain.staff.Staff;
import com.example.skillsauditor.employee.domain.staff.StaffSkill;
import com.example.skillsauditor.employee.domain.staff.interfaces.IRemoveSkillCommand;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;
import com.example.skillsauditor.employee.ui.staff.IStaffApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class StaffApplicationService implements IStaffApplicationService {

    private IStaffRepository staffRepository;

    private IStaffSkillRepository staffSkillRepository;
    private IStaffJpaToStaffMapper staffJpaToStaffMapper;
    private IStaffToStaffJpaMapper staffToStaffJpaMapper;

    @Override
    public void removeStaffSkill(IRemoveSkillCommand removeSkillCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(removeSkillCommand.getStaffId());
        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffMapper.map(staffJpa.get());
            StaffSkillJpaValueObject staffSkillJpaValueObject = staffJpa.get().retrieveSkill(removeSkillCommand.getSkillId());
            staff.removeASkill(removeSkillCommand.getSkillId());
            staffRepository.save(staffToStaffJpaMapper.map(staff));
            staffSkillRepository.removeSkill(staffSkillJpaValueObject);
            // removing a skill isn't working


        } else {
            throw new IllegalArgumentException("Staff id is not recognised");
        }
    }
}
