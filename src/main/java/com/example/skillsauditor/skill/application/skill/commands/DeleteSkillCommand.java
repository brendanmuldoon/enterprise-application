package com.example.skillsauditor.skill.application.skill.commands;

import com.example.skillsauditor.skill.domain.skill.interfaces.IDeleteSkillCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteSkillCommand implements IDeleteSkillCommand {

    private String skillId;
}
