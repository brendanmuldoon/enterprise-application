package com.example.skillsauditor.skill.application.skill.mappers;

import com.example.skillsauditor.skill.domain.skill.DTO.CategoryDTO;
import com.example.skillsauditor.skill.domain.skill.DTO.SkillDTO;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

import java.util.Optional;

public class SkillJpaToDTOMapper {

    private SkillJpaToDTOMapper(){}

    public static Optional<SkillDTO> convertSkillToDTO(SkillJpa skillJpa) {

        SkillDTO skillDTO = mapToSkillDTP(skillJpa);

        return Optional.of(skillDTO);
    }

    private static SkillDTO mapToSkillDTP(SkillJpa skillJpa) {
        CategoryDTO categoryDTO = new CategoryDTO(skillJpa.getCategory().getId(), skillJpa.getCategory().getDescription());
        return new SkillDTO(skillJpa.getId(), skillJpa.getDescription(), categoryDTO);
    }
}
