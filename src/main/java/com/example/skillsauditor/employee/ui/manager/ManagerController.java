package com.example.skillsauditor.employee.ui.manager;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // find all staff of managers team
    // find all staff with certain skill
    // find all skills by category
    // find all staff with expired skills
    // create staff member
    // create/ edit/ delete skill
    // create/ edit/ delete category
    // allocate staff to manager

}
