package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.ContactMessage;
import com.nagarajan.profolio.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public Mono<ContactMessage> sendMessage(@Valid @RequestBody ContactMessage message) {
        return contactService.saveMessage(message)
                .onErrorMap(e -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}