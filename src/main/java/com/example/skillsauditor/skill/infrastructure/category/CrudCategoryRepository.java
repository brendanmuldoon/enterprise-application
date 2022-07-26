package com.example.skillsauditor.skill.infrastructure.category;

import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import org.springframework.data.repository.CrudRepository;

public interface CrudCategoryRepository extends CrudRepository<CategoryJpaValueObject, String> {
}
