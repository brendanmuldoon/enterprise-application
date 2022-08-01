package com.example.skillsauditor.skill.infrastructure.category;

import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudCategoryRepository extends CrudRepository<CategoryJpaValueObject, String> {
    Optional<CategoryJpaValueObject> findByDescription(String description);
}
