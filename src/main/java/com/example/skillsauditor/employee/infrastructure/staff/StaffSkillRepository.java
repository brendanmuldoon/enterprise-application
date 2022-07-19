package com.example.skillsauditor.employee.infrastructure.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffSkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StaffSkillRepository implements IStaffSkillRepository {

    private CrudStaffSkillRepository repository;

    @Override
    public void removeSkill(StaffSkillJpaValueObject staffSkillJpaValueObject) {
        repository.delete(staffSkillJpaValueObject);
    }
}
