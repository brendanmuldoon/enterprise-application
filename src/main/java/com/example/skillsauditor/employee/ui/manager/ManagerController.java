package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.application.manager.commands.UpdateManagerTeamCommand;
import com.example.skillsauditor.employee.application.manager.queries.GetTeamBySkillIdQuery;
import com.example.skillsauditor.employee.domain.manager.Manager;
import com.example.skillsauditor.employee.domain.manager.interfaces.IGetTeamBySkillIdQuery;
import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
@AllArgsConstructor
public class ManagerController {

    private IManagerQueryHandler queryHandler;

    private IManagerApplicationService applicationService;

    // find all managers
    @GetMapping("/findAll")
    public Iterable<?> getAllManagerDetails() {
        return queryHandler.findAll();
    }

    // find manager by id
    @GetMapping("{manager_id}")
    public Optional<?> getManagerById(@PathVariable(value = "manager_id") String managerId) {
        Optional<?> response = queryHandler.findByManagerId(managerId);
        if(response.isPresent()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Manager id: '%s' not found", managerId));
        }
    }

    // find all staff in managers team by manager id
    @GetMapping("/team/{manager_id}")
    public List<?> getManagerTeamById(@PathVariable(value = "manager_id") String managerId) {
        List<?> response = queryHandler.findTeamByManagerId(managerId);
        if(!response.isEmpty()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Manager id: '%s' not found", managerId));
        }
    }

    // find all staff with certain skill
    @GetMapping("/team/bySkill")
    public List<?> getManagerTeamBySkillId(@RequestBody GetTeamBySkillIdQuery getTeamBySkillIdQuery) {
        List<?> response = queryHandler.findTeamBySkillId(getTeamBySkillIdQuery);
        if(!response.isEmpty()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // find all skills by category
    // find all staff with expired skills

    // create staff member - this is in the staff controller

    // create/ edit/ delete skill
    // create/ edit/ delete category

    // allocate staff to manager
    @PutMapping("/team/updateTeam")
    public void updateManagerTeam(@RequestBody UpdateManagerTeamCommand updateManagerTeamCommand) {
        applicationService.addStaffToManagerTeam(updateManagerTeamCommand);
    }

}
