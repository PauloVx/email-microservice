package com.ms.email.controllers;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<Email> sendingEmail(
            @RequestBody
            @Valid
            EmailDTO emailDTO
    ) {
        var email = new Email();

        BeanUtils.copyProperties(emailDTO, email);
        this.emailService.sendEmail(email);
        return new ResponseEntity<Email>(email, HttpStatus.CREATED);
    }
}
