package com.financialhouse.dto.form.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sinan
 */

@Data
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String status;
}
