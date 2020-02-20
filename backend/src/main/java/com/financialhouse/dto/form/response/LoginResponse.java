package com.financialhouse.dto.form.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Sinan
 */

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String status;
    private String email;
}
