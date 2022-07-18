package com.example.skillsauditor.employee.application.staff.commands;

import com.example.skillsauditor.employee.domain.staff.interfaces.IRemoveSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RemoveSkillCommand implements IRemoveSkillCommand {
    private String staffId;
    private String skillId;
}
