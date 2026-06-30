package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.Skill;
import com.nagarajan.profolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;

    public Flux<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}