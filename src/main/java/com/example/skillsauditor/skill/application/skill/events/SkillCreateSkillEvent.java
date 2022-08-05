package com.example.skillsauditor.skill.application.skill.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillCreateSkillEvent {

    private String id;
    private String description;
    private String category;

}
