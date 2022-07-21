package com.example.skillsauditor.employee.domain.manager.DTO;

import com.example.skillsauditor.employee.domain.staff.DTO.StaffSkillDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class ManagerTeamDTO {
    private String staffId;
    private String staffFirstName;
    private String staffSurname;
    private List<StaffSkillDTO> skills;
}
