package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.ContactMessage;
import com.nagarajan.profolio.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactMessageRepository contactMessageRepository;

    public Mono<ContactMessage> saveMessage(ContactMessage message) {
        message.setTimestamp(Instant.now());
        message.setRead(false);
        return contactMessageRepository.save(message);
    }
}