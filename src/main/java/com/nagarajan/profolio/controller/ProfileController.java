package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.Profile;
import com.nagarajan.profolio.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public Mono<Profile> getProfile() {
        return profileService.getProfile();
    }
}