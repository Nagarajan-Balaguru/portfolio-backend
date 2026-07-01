package com.nagarajan.profolio.repository;

import com.nagarajan.profolio.model.Education;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends ReactiveCrudRepository<Education, String> {
}