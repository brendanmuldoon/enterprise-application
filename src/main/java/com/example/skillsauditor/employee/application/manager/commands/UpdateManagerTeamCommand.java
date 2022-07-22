package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateManagerTeamCommand implements IUpdateManagerTeamCommand {

    private String managerId;
    private String staffId;
}
