package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.Education;
import com.nagarajan.profolio.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping
    public Flux<Education> getAllEducation() {
        return educationService.getAllEducation();
    }
}