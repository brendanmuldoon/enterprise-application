package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.RemoveSkillCommand;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = RemoveSkillCommand.class)
public interface IRemoveSkillCommand {

    String getStaffId();

    String getSkillId();

}
