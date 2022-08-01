package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.application.manager.commands.DeleteSkillCommand;
import com.example.skillsauditor.employee.application.manager.commands.EditSkillCommand;
import com.example.skillsauditor.employee.application.manager.commands.UpdateManagerTeamCommand;
import com.example.skillsauditor.employee.application.manager.queries.GetTeamBySkillIdQuery;
import com.example.skillsauditor.employee.application.manager.commands.CreateSkillCommand;
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
    @GetMapping("/findAll") // REMOVE
    public Iterable<?> getAllManagerDetails() {
        return queryHandler.findAll();
    }

    // find manager by id
    @GetMapping("{manager_id}") // REMOVE
    public Optional<?> getManagerById(@PathVariable(value = "manager_id") String managerId) {
        Optional<?> response = queryHandler.findByManagerId(managerId);
        if(response.isPresent()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Manager id: '%s' not found", managerId));
        }
    }

    // find all staff in managers team by manager id
    @GetMapping("/team/{manager_id}") // REMOVE
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

    // find all staff with expired skills -- can't do this until I set up a real DB

    // allocate staff to manager
    @PutMapping("/team/addToTeam")
    public void updateManagerTeam(@RequestBody UpdateManagerTeamCommand updateManagerTeamCommand) {
        applicationService.addStaffToManagerTeam(updateManagerTeamCommand);
    }

    // Add skill
    @PostMapping("/createSkill")
    public void createSkill(@RequestBody CreateSkillCommand createSkillCommand) {
        applicationService.createSkill(createSkillCommand);
    }
    // edit skill
    @PutMapping("/editSkill")
    public void editSkill(@RequestBody EditSkillCommand editSkillCommand) {
        applicationService.editSkill(editSkillCommand);
    }

    // delete skill
    @DeleteMapping("/deleteSkill")
    public void deleteSkill(@RequestBody DeleteSkillCommand deleteSkillCommand) {
        applicationService.deleteSkill(deleteSkillCommand);
    }
    // add category
    // edit category
    // remove category
    // view all skills by category

}
