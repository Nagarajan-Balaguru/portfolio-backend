package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.Experience;
import com.nagarajan.profolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @GetMapping
    public Flux<Experience> getAllExperience() {
        return experienceService.getAllExperience();
    }
}