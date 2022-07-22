package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.AddStaffSkillCommand;
import com.example.skillsauditor.employee.domain.staff.ExpirationDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public interface IAddStaffSkillCommand {

    String getSkillId();
    String getStrengthOfSkill();
    ExpirationDate getExpirationDate();
    String getStaffId();
}
