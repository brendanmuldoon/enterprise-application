package com.example.skillsauditor.skill.domain.skill.interfaces;

import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;

public interface ISkillJpa {

    String getId();

    void setId(String id);

    String getDescription();

    void setDescription(String description);

    CategoryJpaValueObject getCategory();

    void setCategory(CategoryJpaValueObject category);
}
