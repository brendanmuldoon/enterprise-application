package com.example.skillsauditor.skill.domain.skill.interfaces;

import com.example.skillsauditor.skill.domain.skill.Category;

public interface ICreateSkillCommand {

    String getDescription();
    String getCategoryId();
}
