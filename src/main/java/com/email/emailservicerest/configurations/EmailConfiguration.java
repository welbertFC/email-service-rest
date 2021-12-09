package com.email.emailservicerest.configurations;

import com.email.emailservicerest.services.email.EmailService;
import com.email.emailservicerest.services.SmtpGmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {

    @Bean
    public EmailService emailService() {
        return new SmtpGmailService();
    }


}
