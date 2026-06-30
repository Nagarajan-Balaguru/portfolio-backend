package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.Skill;
import com.nagarajan.profolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public Flux<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }
}