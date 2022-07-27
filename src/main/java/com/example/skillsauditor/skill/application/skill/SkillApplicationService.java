package com.example.skillsauditor.skill.application.skill;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.application.skill.commands.DeleteSkillCommand;
import com.example.skillsauditor.skill.application.skill.commands.EditSkillCommand;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillJpaToSkillMapper;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillToSkillJpaMapper;
import com.example.skillsauditor.skill.domain.common.UniqueIDFactory;
import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.skill.domain.skill.interfaces.ICreateSkillCommand;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;
import com.example.skillsauditor.skill.ui.skill.ISkillApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class SkillApplicationService implements ISkillApplicationService {

    private ISkillRepository skillRepository;
    private ICategoryRepository categoryRepository;
    private ISkillToSkillJpaMapper skillToSkillJpaMapper;
    private ISkillJpaToSkillMapper skillJpaToSkillMapper;
    @Override
    public void createSkill(ICreateSkillCommand createSkillCommand) {
        Optional<CategoryJpaValueObject> category = categoryRepository.findById(createSkillCommand.getCategoryId());
        if (category.isPresent()) {

            Identity identity = UniqueIDFactory.createID();

            Skill skill = Skill.skillOf(identity, createSkillCommand.getDescription(), createSkillCommand.getCategoryId());
            skillRepository.save(skillToSkillJpaMapper.map(skill, category.get()));
        } else {
            throw new IllegalArgumentException("Category not found");
        }

    }

    @Override
    public void editSkill(EditSkillCommand editSkillCommand) {
        Optional<SkillJpa> skillJpa = skillRepository.findById(editSkillCommand.getSkillId());
        Optional<CategoryJpaValueObject> categoryJpaValueObject = categoryRepository.findById(editSkillCommand.getCategoryId());
        if(skillJpa.isPresent() && categoryJpaValueObject.isPresent()) {
            Skill skill = skillJpaToSkillMapper.map(skillJpa.get());
            skill.update(editSkillCommand);
            skillRepository.save(skillToSkillJpaMapper.map(skill, categoryJpaValueObject.get()));
        } else {
            throw new IllegalArgumentException("Category not found");
        }
    }

    @Override
    public void deleteSkill(DeleteSkillCommand deleteSkillCommand) {
        Optional<SkillJpa> skillJpa = skillRepository.findById(deleteSkillCommand.getSkillId());
        if (skillJpa.isPresent()) {
            skillRepository.delete(skillJpa.get());
        }else {
            throw new IllegalArgumentException("Category not found");
        }
    }


}
