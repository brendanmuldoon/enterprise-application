package com.example.skillsauditor.skill.application.skill;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillToSkillJpaMapper;
import com.example.skillsauditor.skill.domain.common.UniqueIDFactory;
import com.example.skillsauditor.skill.domain.skill.Category;
import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.skill.domain.skill.interfaces.ICreateSkillCommand;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
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
}
