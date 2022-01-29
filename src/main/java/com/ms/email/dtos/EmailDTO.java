package com.ms.email.dtos;

import com.ms.email.models.Email;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmailDTO {

    @NotBlank
    private String ownerRef;

    @NotBlank
    @javax.validation.constraints.Email
    private String emailFrom;

    @NotBlank
    @javax.validation.constraints.Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;
    
}
