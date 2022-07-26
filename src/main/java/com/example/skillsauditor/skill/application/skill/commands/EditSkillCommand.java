package com.example.skillsauditor.skill.application.skill.commands;

import com.example.skillsauditor.skill.domain.skill.interfaces.IEditSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditSkillCommand implements IEditSkillCommand {

    private String skillId;
    private String description;
    private String categoryId;

}
