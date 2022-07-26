package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.skill.application.skill.interfaces.ISkillToSkillJpaMapper;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;
import org.springframework.stereotype.Component;

@Component
public class SkillToSkillJpaMapper implements ISkillToSkillJpaMapper {

    @Override
    public SkillJpa map(Skill skill, CategoryJpaValueObject category) {

        CategoryJpaValueObject categoryJpaValueObject = CategoryJpaValueObject.categoryJpaOf(category.getId(), category.getDescription());

        return SkillJpa.skillJpaOf(
                skill.id().id(),
                skill.description(),
                categoryJpaValueObject);

    }
}
