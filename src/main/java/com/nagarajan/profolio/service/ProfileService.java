package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.Profile;
import com.nagarajan.profolio.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public Mono<Profile> getProfile() {
        return profileRepository.findAll().next();
    }
}