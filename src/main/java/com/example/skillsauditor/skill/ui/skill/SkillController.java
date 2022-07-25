package com.example.skillsauditor.skill.ui.skill;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/skill")
@AllArgsConstructor
public class SkillController {

    private ISkillQueryHandler queryHandler;

    // create skill / edit skill/ delete skill
    // create/ edit/ delete category
    // find all skills by category

    @GetMapping("/findAll")
    public Iterable<?> findAllSkills() {
        return queryHandler.findAll();
    }

    @GetMapping("/{skill_id}")
    public Optional<?> getSkillById(@PathVariable(name = "skill_id") String skillId) {
        Optional<?> response = queryHandler.findBySkillId(skillId);
        if(response.isPresent()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Skill id: '%s' not found", skillId));
        }
    }
}
