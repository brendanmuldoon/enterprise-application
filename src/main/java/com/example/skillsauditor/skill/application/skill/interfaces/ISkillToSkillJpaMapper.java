package com.example.skillsauditor.skill.application.skill.interfaces;

import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

import java.util.Optional;

public interface ISkillToSkillJpaMapper {
    SkillJpa map(Skill skill, CategoryJpaValueObject category);
}
