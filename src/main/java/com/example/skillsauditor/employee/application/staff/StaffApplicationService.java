package com.example.skillsauditor.employee.application.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffJpaToStaffMapper;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffSkillRepository;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffToStaffJpaMapper;
import com.example.skillsauditor.employee.domain.staff.Staff;
import com.example.skillsauditor.employee.domain.staff.StaffSkill;
import com.example.skillsauditor.employee.domain.staff.StrengthOfSkill;
import com.example.skillsauditor.employee.domain.staff.interfaces.IAddStaffSkillCommand;
import com.example.skillsauditor.employee.domain.staff.interfaces.IRemoveStaffSkillCommand;
import com.example.skillsauditor.employee.domain.staff.interfaces.IUpdateStaffDetailsCommand;
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
    public void removeStaffSkill(IRemoveStaffSkillCommand removeSkillCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(removeSkillCommand.getStaffId());
        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffMapper.map(staffJpa.get());
            StaffSkillJpaValueObject staffSkillJpaValueObject = staffJpa.get().retrieveSkill(removeSkillCommand.getSkillId());
            staff.removeASkill(removeSkillCommand.getSkillId());
            staffRepository.save(staffToStaffJpaMapper.map(staff));
            staffSkillRepository.removeSkill(staffSkillJpaValueObject);
        } else {
            throw new IllegalArgumentException("Staff id is not recognised");
        }
    }

    @Override
    public void addStaffSkill(IAddStaffSkillCommand addStaffSkillCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(addStaffSkillCommand.getStaffId());
        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffMapper.map(staffJpa.get());

            StaffSkill staffSkill = new StaffSkill(addStaffSkillCommand.getSkillId(),
                    StrengthOfSkill.valueOf(addStaffSkillCommand.getStrengthOfSkill()),
                    addStaffSkillCommand.getExpirationDate());
            staff.addSkill(staffSkill);
            staffRepository.save(staffToStaffJpaMapper.map(staff));
        } else {
            throw new IllegalArgumentException("Staff id is not recognised");
        }
    }

    @Override
    public void updateStaffDetails(IUpdateStaffDetailsCommand updateStaffDetailsCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(updateStaffDetailsCommand.getStaffId());
        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffMapper.map(staffJpa.get());
            staff.updateStaffDetails(updateStaffDetailsCommand);
            staffRepository.save(staffToStaffJpaMapper.map(staff));
        } else {
            throw new IllegalArgumentException("Staff id is not recognised");
        }
    }
}
