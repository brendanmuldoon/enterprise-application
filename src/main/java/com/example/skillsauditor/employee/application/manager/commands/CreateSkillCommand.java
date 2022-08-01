package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.employee.domain.manager.interfaces.ICreateSkillCommand;
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
