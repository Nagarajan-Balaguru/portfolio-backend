package com.nagarajan.profolio.repository;

import com.nagarajan.profolio.model.Profile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends ReactiveCrudRepository<Profile, String> {
}