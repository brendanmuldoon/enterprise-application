package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.skill.application.category.interfaces.ICategoryToCategoryJpaMapper;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryJpaMapper implements ICategoryToCategoryJpaMapper {

    @Override
    public CategoryJpaValueObject map(Category category) {
        return new CategoryJpaValueObject(category.id().id(), category.description());
    }
}
