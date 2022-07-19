package com.example.skillsauditor.employee.ui.staff;

import com.example.skillsauditor.employee.domain.staff.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/staff")
@RestController
@AllArgsConstructor
public class StaffController {

    private IStaffQueryHandler queryHandler;
    private IStaffApplicationService applicationService;

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

    @PutMapping("/updateDetails")
    public void updateStaffDetails(@RequestBody IUpdateStaffDetailsCommand updateStaffDetailsCommand) {
        applicationService.updateStaffDetails(updateStaffDetailsCommand);
    }

    // create staff

    @DeleteMapping("/deleteStaff")
    public void deleteStaff(@RequestBody IDeleteStaffCommand deleteStaffCommand) {
        applicationService.deleteStaff(deleteStaffCommand);
    }

    @GetMapping("staffSkill/{staffId}")
    public List<?> getStaffSkillsDetailsByStaffId(@PathVariable(value = "staffId") String staffId) {
        List<?> response = queryHandler.findSkillsByStaffId(staffId);
        if(!response.isEmpty()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Staff id: '%s' not found", staffId));
        }
    }

    @PostMapping("/staffSkill/add")
    public void addStaffSkill(@RequestBody IAddStaffSkillCommand addStaffSkillCommand) {
        applicationService.addStaffSkill(addStaffSkillCommand);
    }

    @DeleteMapping("/staffSkill/removeSkill")
    public void removeStaffSkill(@RequestBody IRemoveStaffSkillCommand removeStaffSkillCommand) {
        applicationService.removeStaffSkill(removeStaffSkillCommand);
    }

    // update staffSkill
    @PutMapping("/staffSkill/updateSkill")
    public void updateStaffSkill(@RequestBody IUpdateStaffSkillCommand updateStaffSkillCommand) {
        applicationService.updateStaffSkill(updateStaffSkillCommand);
    }

}
