package com.example.skillsauditor.skill.application.skill.interfaces;

import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

public interface ISkillRepository {
    Iterable<SkillJpa> findAll();
}
