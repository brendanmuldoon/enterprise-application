package com.example.skillsauditor.employee.ui.staff;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/staff")
@RestController
@AllArgsConstructor
public class StaffController {

    private IStaffQueryHandler queryHandler;

    @GetMapping("/findAll")
    public Iterable<?> getAllStaffDetails() {
        System.out.println("request received");
        return queryHandler.findAll();
    }
}
