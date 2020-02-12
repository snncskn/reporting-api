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
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotNull
    @NotBlank(message = "Password cannot be blank")
    private String password;

}
