package com.example.skillsauditor.employee.infrastructure.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffSkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StaffSkillRepository implements IStaffSkillRepository {

    private CrudStaffSkillRepository repository;

    @Override
    public void removeSkill(StaffSkillJpaValueObject staffSkillJpaValueObject) {
        repository.delete(staffSkillJpaValueObject);
    }

    @Override
    public void save(StaffSkillJpaValueObject staffSkillJpaValueObject) {
        repository.save(staffSkillJpaValueObject);
    }

    @Override
    public Optional<StaffSkillJpaValueObject> findBySkillId(String skillId) {
        return repository.findBySkillId(skillId);
    }
}
