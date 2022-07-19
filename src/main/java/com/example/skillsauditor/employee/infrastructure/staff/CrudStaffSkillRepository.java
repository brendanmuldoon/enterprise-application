package com.example.skillsauditor.employee.infrastructure.staff;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudStaffSkillRepository extends CrudRepository<StaffSkillJpaValueObject, Long> {
    Optional<StaffSkillJpaValueObject> findBySkillId(String skillId);
}
