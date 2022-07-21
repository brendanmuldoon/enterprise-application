package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.domain.manager.Manager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
@AllArgsConstructor
public class ManagerController {

    private IManagerQueryHandler queryHandler;

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

    // find all staff of managers team
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
    // find all skills by category
    // find all staff with expired skills
    // create staff member
    // create/ edit/ delete skill
    // create/ edit/ delete category
    // allocate staff to manager

}
