package com.example.skillsauditor.skill.application.category.interfaces;

import com.example.skillsauditor.skill.domain.skill.Category;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;

public interface ICategoryToCategoryJpaMapper {
    CategoryJpaValueObject map(Category category);
}
