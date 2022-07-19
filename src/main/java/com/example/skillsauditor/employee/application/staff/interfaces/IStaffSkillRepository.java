package com.example.skillsauditor.employee.application.staff.interfaces;

import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;

import java.util.Optional;

public interface IStaffSkillRepository {

    void removeSkill(StaffSkillJpaValueObject staffSkillJpaValueObject);

    void save(StaffSkillJpaValueObject staffSkillJpaValueObject);

    Optional<StaffSkillJpaValueObject> findBySkillId(String skillId);
}
