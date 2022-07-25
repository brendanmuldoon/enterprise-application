package com.example.skillsauditor.skill.ui.skill;

import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

public interface ISkillQueryHandler {

    Iterable<SkillJpa> findAll();
}
