package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;

public interface IStaffSkillRepository {

    void removeSkill(StaffSkillJpaValueObject staffSkillJpaValueObject);
}
