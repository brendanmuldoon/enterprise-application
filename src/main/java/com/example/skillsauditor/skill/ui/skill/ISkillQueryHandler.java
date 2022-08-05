package com.example.skillsauditor.skill.ui.skill;

import com.example.skillsauditor.skill.domain.skill.DTO.SkillDTO;
import com.example.skillsauditor.skill.domain.skill.DTO.SkillDTOList;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

import java.util.List;
import java.util.Optional;

public interface ISkillQueryHandler {

    Iterable<SkillJpa> findAll();

    Optional<SkillDTO> findBySkillId(String skillId);

    SkillDTOList findByCategoryId(String categoryId);
}
