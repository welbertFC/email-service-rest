package com.email.emailservicerest.services;

import com.email.emailservicerest.services.email.AbstractEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;

@Slf4j
public class MockEmail extends AbstractEmailService {


    @Override
    public void send(SimpleMailMessage message) {
        log.info("enviando email.......");
        log.info(message.toString());
        log.info("email enviado.......");


    }
}
