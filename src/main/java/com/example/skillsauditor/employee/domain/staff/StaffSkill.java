package com.example.skillsauditor.employee.domain.staff;

import com.example.skillsauditor.employee.domain.common.ValueObject;
import lombok.Getter;
import lombok.Setter;

import static com.example.skillsauditor.ApplicationConstants.SKILL_ID_ERROR_MSG_EMPTY;

@Getter
@Setter
public class StaffSkill extends ValueObject {

    private String skillId;
    private StrengthOfSkill strengthOfSkill;
    private ExpirationDate expiry;

    public StaffSkill(String skillId, StrengthOfSkill strengthOfSkill, ExpirationDate expiry) {
        setSkillId(skillId);
        setStrengthOfSkill(strengthOfSkill);
        setExpiry(expiry);
    }

    private void setExpiry(ExpirationDate expiry) {
        this.expiry = expiry;
    }

    private void setStrengthOfSkill(StrengthOfSkill strengthOfSkill) {
        this.strengthOfSkill = strengthOfSkill;
    }

    private void setSkillId(String skillId) {
        assertArgumentNotEmpty(skillId, SKILL_ID_ERROR_MSG_EMPTY);
        this.skillId = skillId;
    }

    public boolean equals(Object o){
        if (o == null && o.getClass() != this.getClass()){
            return false;
        }
        StaffSkill staffSkill = (StaffSkill) o;

        return staffSkill.skillId==this.skillId;

    }

    public String skillId() {
        return skillId;
    }

    public StrengthOfSkill strengthOfSkill() {
        return strengthOfSkill;
    }

    public ExpirationDate expiry() {
        return expiry;
    }
}
