package com.nagarajan.profolio.service;

import com.nagarajan.profolio.model.ContactMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.notification.email}")
    private String notificationEmail;

    public void sendContactNotification(ContactMessage message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(notificationEmail);
            mail.setSubject("📬 New Portfolio Contact from " + message.getName());
            mail.setText(
                "You have a new message from your portfolio!\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Name    : " + message.getName() + "\n" +
                "Email   : " + message.getEmail() + "\n" +
                "Message : " + message.getMessage() + "\n" +
                "Time    : " + message.getTimestamp() + "\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Reply directly to: " + message.getEmail()
            );
            mail.setReplyTo(message.getEmail());
            mailSender.send(mail);
            log.info("Email notification sent for contact from: {}", message.getEmail());
        } catch (Exception e) {
            log.error("Failed to send email notification: {}", e.getMessage());
        }
    }
}