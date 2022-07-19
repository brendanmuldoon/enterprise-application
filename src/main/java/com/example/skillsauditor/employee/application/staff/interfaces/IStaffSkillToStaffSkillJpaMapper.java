package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.domain.staff.StaffSkill;
import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;

public interface IStaffSkillToStaffSkillJpaMapper {
    StaffSkillJpaValueObject map(StaffSkill skill, String staffId);
}
