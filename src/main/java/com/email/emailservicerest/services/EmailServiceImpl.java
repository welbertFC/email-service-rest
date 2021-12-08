package com.email.emailservicerest.services;

import com.email.emailservicerest.exceptions.ObjectNotFoundException;
import com.email.emailservicerest.models.EmailModel;
import com.email.emailservicerest.models.enums.StatusEmail;
import com.email.emailservicerest.repositorys.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {

    @Value("${default.sender}")
    private String emailFrom;

    private final EmailRepository repository;

    private final EmailService emailService;

    public EmailModel save(EmailModel emailModel) {
        emailModel.setEmailFrom(emailFrom);
        emailModel.generateId();

        try {
            emailService.sendEmail(emailModel);
            emailModel.setStatusEmail(StatusEmail.SEND);
        } catch (MailException exception) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        return repository.save(emailModel);
    }

    public EmailModel findById(UUID idEmail) {
        return repository.findById(idEmail)
                .orElseThrow(ObjectNotFoundException::new);
    }

    public Page<EmailModel> findAllEmail(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
