package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.Project;
import com.nagarajan.profolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public Flux<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
}