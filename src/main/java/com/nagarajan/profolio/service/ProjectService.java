package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.Project;
import com.nagarajan.profolio.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Flux<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}