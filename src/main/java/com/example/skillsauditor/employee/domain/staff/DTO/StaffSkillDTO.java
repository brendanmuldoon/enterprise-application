package com.example.skillsauditor.employee.domain.staff.DTO;

import com.example.skillsauditor.employee.domain.staff.ExpirationDate;
import com.example.skillsauditor.employee.domain.staff.StrengthOfSkill;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class StaffSkillDTO {
    private String skillId;
    private StrengthOfSkill strengthOfSkill;
    private ExpirationDate expiry;
}
