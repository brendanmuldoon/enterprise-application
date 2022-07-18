package com.example.skillsauditor.employee.domain.staff;

public enum StrengthOfSkill {

    BASIC("Basic"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private final String strength;

    StrengthOfSkill(String strength) {
        this.strength = strength;
    }

    public String getStrength() {
        return strength;
    }


}
