package com.example.skillsauditor.skill.infrastructure.skill;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudSkillRepository extends CrudRepository<SkillJpa, String> {
    List<SkillJpa> findAllByCategoryId(String categoryId);
}
