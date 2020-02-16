package com.financialhouse.dto.form.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Sinan
 */

@Data
public class LoginCredentialsForm {

    @Email
    @NotNull
    @NotBlank(message = "email field is required")
    private String email;

    @NotNull
    @NotBlank(message = "password field is required")
    private String password;

}
