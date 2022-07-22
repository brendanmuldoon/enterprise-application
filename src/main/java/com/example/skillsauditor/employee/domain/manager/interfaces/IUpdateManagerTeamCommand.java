package com.example.skillsauditor.employee.domain.manager.interfaces;

import com.example.skillsauditor.employee.application.manager.commands.UpdateManagerTeamCommand;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UpdateManagerTeamCommand.class)
public interface IUpdateManagerTeamCommand {

    String getManagerId();
    String getStaffId();

}
