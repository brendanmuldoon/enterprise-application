package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.UpdateStaffSkillCommand;
import com.example.skillsauditor.employee.domain.staff.ExpirationDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UpdateStaffSkillCommand.class)
public interface IUpdateStaffSkillCommand {

    String getSkillId();
    String getStrengthOfSkill();
    ExpirationDate getExpirationDate();
    String getStaffId();
}
