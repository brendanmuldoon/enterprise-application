package com.example.skillsauditor.employee.domain.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffSkillJpaToStaffSkillMapper;
import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;
import org.springframework.stereotype.Component;

@Component
public class StaffSkillJpaToStaffSkillMapper implements IStaffSkillJpaToStaffSkillMapper {
    @Override
    public StaffSkill map(StaffSkillJpaValueObject staffSkillJpaValueObject) {
        ExpirationDate expirationDate = new ExpirationDate(
                staffSkillJpaValueObject.getExpiry().getMonthValue(),
                staffSkillJpaValueObject.getExpiry().getYear()
        );

        StaffSkill staffSkill = StaffSkill.staffSkillOf(
                staffSkillJpaValueObject.getSkillId(),
                StrengthOfSkill.valueOf(staffSkillJpaValueObject.getStrengthOfSkill().toUpperCase()),
                expirationDate
        );

        staffSkill.setId(staffSkillJpaValueObject.getId());

        return staffSkill;
    }
}
