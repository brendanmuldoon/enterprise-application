package com.example.skillsauditor.skill.application.skill.mappers;

import com.example.skillsauditor.skill.domain.skill.DTO.CategoryDTO;
import com.example.skillsauditor.skill.domain.skill.DTO.SkillDTO;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;

import java.util.ArrayList;
import java.util.List;
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

    public static List<SkillDTO> convertSkillListToDTO(List<SkillJpa> response, String categoryId) {
        List<SkillDTO> skills = new ArrayList<>();

        for (SkillJpa s : response) {
            if(s.getCategory().getId().equals(categoryId)) {
                SkillDTO skill = new SkillDTO(s.getId(),
                        s.getDescription(),
                        new CategoryDTO(s.getCategory().getId(),
                                s.getCategory().getDescription()));
                skills.add(skill);
            }
        }

        return skills;
    }
}
