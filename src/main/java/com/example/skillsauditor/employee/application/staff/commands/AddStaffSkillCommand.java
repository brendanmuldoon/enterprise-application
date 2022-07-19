package com.example.skillsauditor.employee.application.staff.commands;

import com.example.skillsauditor.employee.domain.staff.ExpirationDate;
import com.example.skillsauditor.employee.domain.staff.interfaces.IAddStaffSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddStaffSkillCommand implements IAddStaffSkillCommand {
    private String skillId;
    private String strengthOfSkill;
    private ExpirationDate expirationDate;
    private String staffId;
}
