package com.email.emailservicerest.services;

import com.email.emailservicerest.services.email.AbstractEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpGmailService extends AbstractEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(SimpleMailMessage message) {
        javaMailSender.send(message);

    }
}
