package com.example.skillsauditor.skill.ui.skill;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@AllArgsConstructor
public class SkillController {

    private ISkillQueryHandler queryHandler;

    @GetMapping("/findAll")
    public Iterable<?> findAllSkills() {
        return queryHandler.findAll();
    }
}
