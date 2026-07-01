package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.Education;
import com.nagarajan.profolio.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository educationRepository;

    public Flux<Education> getAllEducation() {
        return educationRepository.findAll();
    }
}