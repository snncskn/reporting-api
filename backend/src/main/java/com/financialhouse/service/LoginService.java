package com.financialhouse.service;

import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import com.financialhouse.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${login.url}")
    private String loginUrl;

    private final HttpUtils httpUtils;

    /**
     * *
     *
     * @param credentials
     * @return
     */
    public Optional<LoginResponse> login(final LoginCredentialsForm credentials) {
        LoginResponse loginResponse = httpUtils.postForLogin(loginUrl, credentials, LoginResponse.class);
        loginResponse.setEmail(credentials.getEmail());
        return Optional.of(loginResponse);
    }
}
