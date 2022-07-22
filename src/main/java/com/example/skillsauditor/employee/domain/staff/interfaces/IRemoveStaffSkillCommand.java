package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.RemoveStaffSkillCommand;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public interface IRemoveStaffSkillCommand {

    String getStaffId();

    String getSkillId();

}
