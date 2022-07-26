package com.example.skillsauditor.skill.application.skill.commands;

import com.example.skillsauditor.skill.domain.skill.Category;
import com.example.skillsauditor.skill.domain.skill.interfaces.ICreateSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateSkillCommand implements ICreateSkillCommand {

    private String description;
    private String categoryId;

}
