package com.email.emailservicerest.services;

import com.email.emailservicerest.models.EmailModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String emailFrom;

    @Override
    public void sendEmail(EmailModel emailModel) {
        var email = prepareEmail(emailModel);
        send(email);
    }

    private SimpleMailMessage prepareEmail(EmailModel emailModel) {
        var message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailModel.getEmailTo());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getText());
        return message;
    }
}
