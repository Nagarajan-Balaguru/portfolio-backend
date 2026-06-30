package com.nagarajan.profolio.controller;

import com.nagarajan.profolio.model.ContactMessage;
import com.nagarajan.profolio.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public Mono<ContactMessage> sendMessage(@RequestBody ContactMessage message) {
        return contactService.saveMessage(message);
    }
}