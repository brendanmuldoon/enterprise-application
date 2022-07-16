package com.example.skillsauditor.employee.domain.staff;

public enum StrengthOfSkill {

    BASIC("Basic"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private String skillLevel;

    StrengthOfSkill(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String strengthOfSkill() {
        return skillLevel;
    }
}
