package com.email.emailservicerest.services.email;

import com.email.emailservicerest.models.EmailModel;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void send(SimpleMailMessage message);

    void sendEmail(EmailModel emailModel);
}
