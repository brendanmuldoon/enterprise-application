package com.example.skillsauditor.skill.application.skill;

import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import com.example.skillsauditor.skill.ui.skill.ISkillQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SkillQueryHandler implements ISkillQueryHandler {

    private ISkillRepository skillRepository;

    @Override
    public Iterable<?> findAll() {
        return skillRepository.findAll();
    }
}
