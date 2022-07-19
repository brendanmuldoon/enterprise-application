package com.example.skillsauditor.employee.application.staff.commands;

import com.example.skillsauditor.employee.domain.staff.interfaces.IRemoveStaffSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RemoveStaffSkillCommand implements IRemoveStaffSkillCommand {
    private String staffId;
    private String skillId;
}
