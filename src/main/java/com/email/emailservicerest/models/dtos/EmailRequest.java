package com.email.emailservicerest.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

    @Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

}
