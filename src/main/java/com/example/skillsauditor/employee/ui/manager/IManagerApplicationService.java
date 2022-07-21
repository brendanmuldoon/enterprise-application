package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;

public interface IManagerApplicationService {
    void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand);
}
