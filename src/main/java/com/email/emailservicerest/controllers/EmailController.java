package com.email.emailservicerest.controllers;

import com.email.emailservicerest.mappers.EmailMapper;
import com.email.emailservicerest.models.dtos.EmailRequest;
import com.email.emailservicerest.models.dtos.EmailResponse;
import com.email.emailservicerest.services.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailServiceImpl service;

    @PostMapping
    public ResponseEntity<EmailResponse> insert(@RequestBody @Valid EmailRequest request) {

        var settingEmail = service.save(EmailMapper.convertToModel(request));
        var uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(settingEmail.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(EmailMapper.convertToResponse(settingEmail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(EmailMapper.convertToResponse(service.findById(id)));
    }

    @GetMapping
    public Page<EmailResponse> listAll(Pageable pageable) {
        return service.findAllEmail(pageable)
                .map(EmailMapper::convertToResponse);
    }

}
