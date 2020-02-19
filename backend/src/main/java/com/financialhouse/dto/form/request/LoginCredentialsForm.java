package com.financialhouse.dto.form.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Sinan
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredentialsForm {

    @Email
    @NotNull
    @NotBlank(message = "email field is required")
    private String email;

    @NotNull
    @NotBlank(message = "password field is required")
    private String password;

}
