package com.example.skillsauditor.skill.infrastructure.skill;

import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SkillRepository implements ISkillRepository {

    private CrudSkillRepository repository;

    @Override
    public Iterable<SkillJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SkillJpa> findById(String skillId) {
        return repository.findById(skillId);
    }
}
