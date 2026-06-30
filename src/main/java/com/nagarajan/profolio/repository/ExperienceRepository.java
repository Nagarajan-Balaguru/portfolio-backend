package com.nagarajan.profolio.repository;

import com.nagarajan.profolio.model.Experience;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends ReactiveCrudRepository<Experience, String> {
}