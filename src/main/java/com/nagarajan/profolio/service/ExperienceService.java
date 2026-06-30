package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.Experience;
import com.nagarajan.profolio.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public Flux<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }
}