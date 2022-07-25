package com.example.skillsauditor.skill.infrastructure.skill;

import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SkillRepository implements ISkillRepository {

    private CrudSkillRepository repository;

    @Override
    public Iterable<SkillJpa> findAll() {
        return repository.findAll();
    }
}
