package com.example.skillsauditor.skill.application.skill.interfaces;

import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

import java.util.List;
import java.util.Optional;

public interface ISkillRepository {
    Iterable<SkillJpa> findAll();

    Optional<SkillJpa> findById(String skillId);

    List<SkillJpa> findByCategoryId(String categoryId);
}
