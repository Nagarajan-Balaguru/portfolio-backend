package com.nagarajan.profolio.repository;

import com.nagarajan.profolio.model.ContactMessage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends ReactiveCrudRepository<ContactMessage, String> {
}