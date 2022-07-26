package com.example.skillsauditor.skill.infrastructure.category;

import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryRepository implements ICategoryRepository {

    private CrudCategoryRepository repository;

    @Override
    public Optional<CategoryJpaValueObject> findById(String id) {
        return repository.findById(id);
    }
}
