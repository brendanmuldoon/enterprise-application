package com.example.skillsauditor.employee.ui.staff;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/staff")
@RestController
@AllArgsConstructor
public class StaffController {

    private IStaffQueryHandler queryHandler;

    @GetMapping("/findAll")
    public Iterable<?> getAllStaffDetails() {
        return queryHandler.findAll();
    }

    @GetMapping("/{staffId}")
    public Optional<?> getStaffDetailsByStaffId(@PathVariable(value = "staffId") String staffId) {
        Optional<?> response = queryHandler.findByStaffId(staffId);
        if(response.isPresent()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff id: '%s' not found", staffId));
        }
    }

    @GetMapping("staffSkills/{staffId}")
    public List<?> getStaffSkillsDetailsByStaffId(@PathVariable(value = "staffId") String staffId) {
        List<?> response = queryHandler.findSkillsByStaffId(staffId);
        if(!response.isEmpty()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff id: '%s' not found", staffId));
        }
    }

}
