package com.example.skillsauditor.skill.application.skill.interfaces;

import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

public interface ISkillJpaToSkillMapper {
    Skill map(SkillJpa skillJpa);
}
