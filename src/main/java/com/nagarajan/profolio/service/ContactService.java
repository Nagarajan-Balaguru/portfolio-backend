package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.ContactMessage;
import com.nagarajan.profolio.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactMessageRepository contactMessageRepository;
    private final EmailService emailService;

    public Mono<ContactMessage> saveMessage(ContactMessage message) {
        message.setTimestamp(Instant.now());
        message.setRead(false);

        return contactMessageRepository.save(message)
                .doOnSuccess(saved -> {
                    // Send email async so it doesn't block the response
                    Mono.fromRunnable(() -> emailService.sendContactNotification(saved))
                        .subscribeOn(Schedulers.boundedElastic())
                        .subscribe();
                });
    }
}