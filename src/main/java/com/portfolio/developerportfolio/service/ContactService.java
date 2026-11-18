package com.portfolio.developerportfolio.service;

import com.portfolio.developerportfolio.model.ContactMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    private final Queue<ContactMessage> messages = new ConcurrentLinkedQueue<>();

    /**
     * Demo implementation: keeps messages in memory for this running application instance.
     * Connect an email provider or database before using this form for real enquiries.
     */
    public void submit(ContactMessage message) {
        messages.add(new ContactMessage(message));
        log.info("A portfolio contact message was received. Total messages in memory: {}", messages.size());
    }

    public int getMessageCount() {
        return messages.size();
    }
}
