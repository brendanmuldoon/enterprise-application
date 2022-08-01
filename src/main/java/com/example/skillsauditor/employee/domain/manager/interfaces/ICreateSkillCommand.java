package com.example.skillsauditor.employee.domain.manager.interfaces;

import com.example.skillsauditor.skill.domain.skill.Category;

public interface ICreateSkillCommand {

    String getDescription();
    String getCategoryId();
}
