package com.financialhouse.dto.form.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class HeaderParameters {
    @NotBlank(message = "token field is required")
    @NotNull(message = "token field is required")
    private String token;
}
