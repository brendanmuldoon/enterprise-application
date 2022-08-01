package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.employee.domain.manager.interfaces.IEditSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditSkillCommand implements IEditSkillCommand {

    private String skillId;
    private String description;

}
