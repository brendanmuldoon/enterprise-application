package com.example.skillsauditor.skill.application.skill;

import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import com.example.skillsauditor.skill.application.skill.mappers.SkillJpaToDTOMapper;
import com.example.skillsauditor.skill.domain.skill.DTO.SkillDTO;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;
import com.example.skillsauditor.skill.ui.skill.ISkillQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkillQueryHandler implements ISkillQueryHandler {

    private ISkillRepository skillRepository;

    @Override
    public Iterable<SkillJpa> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<SkillDTO> findBySkillId(String skillId) {
        Optional<SkillJpa> response = skillRepository.findById(skillId);
        return response.flatMap(SkillJpaToDTOMapper::convertSkillToDTO);
    }

    @Override
    public List<SkillDTO> findByCategoryId(String categoryId) {
        List<SkillJpa> response = skillRepository.findByCategoryId(categoryId);
        if(!response.isEmpty()) {
            return SkillJpaToDTOMapper.convertSkillListToDTO(response, categoryId);
        }
        return new ArrayList<>();
    }

    // add skill
    // edit skill
    // delete skill
    // add category
    // edit category
    // delete category
    // view all skills by category

}
