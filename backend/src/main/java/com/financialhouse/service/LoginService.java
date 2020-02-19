package com.financialhouse.service;

import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import com.financialhouse.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sinan
 */

@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${login.url}")
    private String loginUrl;

    private final HttpUtils httpUtils;

    public Optional<LoginResponse> login(final LoginCredentialsForm form) {
        LoginResponse loginResponse = httpUtils.postForLogin(loginUrl, form, LoginResponse.class);
        loginResponse.setEmail(form.getEmail());
        return Optional.of(loginResponse);
    }
}
