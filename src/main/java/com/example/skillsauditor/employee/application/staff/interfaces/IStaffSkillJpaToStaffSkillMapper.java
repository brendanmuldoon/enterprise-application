package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.domain.staff.StaffSkill;
import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;
import org.springframework.stereotype.Component;

@Component
public interface IStaffSkillJpaToStaffSkillMapper {
    StaffSkill map(StaffSkillJpaValueObject staffSkillJpaValueObject);

}
