package com.email.emailservicerest.mappers;

import com.email.emailservicerest.models.EmailModel;
import com.email.emailservicerest.models.dtos.EmailRequest;
import com.email.emailservicerest.models.dtos.EmailResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private EmailMapper() {
    }

    public static EmailModel convertToModel(EmailRequest emailRequest) {
        return mapper.map(emailRequest, EmailModel.class);
    }

    public static EmailResponse convertToResponse(EmailModel emailModel) {
        return mapper.map(emailModel, EmailResponse.class);
    }
}
