package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.employee.domain.manager.interfaces.IDeleteSkillCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteSkillCommand implements IDeleteSkillCommand {

    private String skillId;
}
