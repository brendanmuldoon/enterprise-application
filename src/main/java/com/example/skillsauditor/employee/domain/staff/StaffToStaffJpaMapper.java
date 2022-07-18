package com.example.skillsauditor.employee.domain.staff;

import com.example.skillsauditor.employee.application.staff.interfaces.IStaffToStaffJpaMapper;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.infrastructure.staff.StaffSkillJpaValueObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Component
public class StaffToStaffJpaMapper implements IStaffToStaffJpaMapper {

    @Override
    public StaffJpa map(Staff staff) {
        StaffJpa staffJpa = StaffJpa.staffJpaOf(
                staff.id().id(),
                staff.fullName().firstName(),
                staff.fullName().surname(),
                staff.address().houseNumber(),
                staff.address().streetName(),
                staff.address().postcode(),
                staff.role().getEmployeeRole(),
                staff.securityCredentials().username(),
                staff.securityCredentials().password()
        );

        for (StaffSkill skill : staff.retrieveAllSkills()) {
            LocalDate expiryDate = convertExpirationToLocaleDate(skill);

            StaffSkillJpaValueObject staffSkillJpaValueObject =
                    new StaffSkillJpaValueObject(skill.getId(),
                            skill.getSkillId(),
                            skill.getStrengthOfSkill().getStrength(),
                            expiryDate);
            staffSkillJpaValueObject.setId(skill.getId());
            staffSkillJpaValueObject.setStaff(staffJpa.getId());
            staffJpa.addSkill(staffSkillJpaValueObject);
        }
        return staffJpa;
    }

    private LocalDate convertExpirationToLocaleDate(StaffSkill skill) {
        LocalDate expirationDate =LocalDate.of(skill.getExpiry().getYear(),
                skill.getExpiry().getMonth(),
                1);
        expirationDate.with(lastDayOfMonth());//set to last day of month
        return expirationDate;
    }
}
