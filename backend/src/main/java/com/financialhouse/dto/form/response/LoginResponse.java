package com.financialhouse.dto.form.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Sinan
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginResponse {
    private String token;
    private String status;
    private String email;
}
