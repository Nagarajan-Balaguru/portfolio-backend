package com.nagarajan.profolio.repository;

import com.nagarajan.profolio.model.Skill;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends ReactiveCrudRepository<Skill, String> {
}