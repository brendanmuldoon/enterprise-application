package com.example.skillsauditor.skill.ui.skill;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skill")
@AllArgsConstructor
public class SkillController {

    private ISkillQueryHandler queryHandler;


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

    // view all skills by category
    @GetMapping("/findAllSkillsByCategory/{category_id}")
    public List<?> getSkillsByCategoryId(@PathVariable(name = "category_id") String categoryId){
        List<?> response = queryHandler.findByCategoryId(categoryId);
        if(!response.isEmpty()) {
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Skill id: '%s' not found", categoryId));
        }
    }
    // add skill
    // edit skill
    // delete skill
    // add category
    // edit category
    // delete category

}
