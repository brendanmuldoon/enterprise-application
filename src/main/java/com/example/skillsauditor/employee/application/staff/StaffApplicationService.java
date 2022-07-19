package com.example.skillsauditor.employee.application.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.*;
import com.example.skillsauditor.employee.domain.staff.Staff;
import com.example.skillsauditor.employee.domain.staff.StaffSkill;
import com.example.skillsauditor.employee.domain.staff.StrengthOfSkill;
import com.example.skillsauditor.employee.domain.staff.interfaces.*;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;
import com.example.skillsauditor.employee.ui.staff.IStaffApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    private IStaffSkillJpaToStaffSkillMapper staffSkillJpaToStaffSkill;
    private IStaffSkillToStaffSkillJpaMapper staffSkillToStaffSkillJpaMapper;

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

            StaffSkill staffSkill = new StaffSkill(
                    addStaffSkillCommand.getSkillId(),
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

    @Override
    public void deleteStaff(IDeleteStaffCommand deleteStaffCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(deleteStaffCommand.getStaffId());
        if(staffJpa.isPresent()) {
            staffRepository.delete(staffJpa.get());
        } else {
            throw new IllegalArgumentException("Staff id is not recognised");
        }
    }

//    @Override
//    public void updateStaffSkill(IUpdateStaffSkillCommand updateStaffSkillCommand) {
//        Optional<StaffJpa> staffJpa = staffRepository.findById(updateStaffSkillCommand.getStaffId());
//        if(staffJpa.isPresent()) {
//            Staff staff = staffJpaToStaffMapper.map(staffJpa.get());
//            // map skill
//            StaffSkillJpaValueObject staffSkillJpaValueObject = staffJpa.get().retrieveSkill(updateStaffSkillCommand.getSkillId());
//            StaffSkill skill = staffSkillJpaToStaffSkill.map(staffSkillJpaValueObject);
//            //
//
//            skill.updateStaffSkill(updateStaffSkillCommand);
//            staff.updateASkill(skill);
//            StaffSkillJpaValueObject o = staffSkillToStaffSkillJpaMapper.map(skill, updateStaffSkillCommand.getStaffId());
//            staffSkillRepository.save(o);
//
//            staffRepository.save(staffToStaffJpaMapper.map(staff));
//        } else {
//            throw new IllegalArgumentException("Staff id is not recognised");
//        }
//    }

    @Override
    public void updateStaffSkill(IUpdateStaffSkillCommand updateStaffSkillCommand) {
        Optional<StaffSkillJpaValueObject> staffSkill = staffSkillRepository.findBySkillId(updateStaffSkillCommand.getSkillId());
        if(staffSkill.isPresent()) {
            StaffSkill skill = staffSkillJpaToStaffSkill.map(staffSkill.get());
            skill.updateStaffSkill(updateStaffSkillCommand);
            StaffSkillJpaValueObject o = staffSkillToStaffSkillJpaMapper.map(skill, updateStaffSkillCommand.getStaffId());
            staffSkillRepository.save(o);


        } else {
            throw new IllegalArgumentException("Staff id is not recognised");
        }
    }
}
