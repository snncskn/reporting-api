package com.financialhouse.service;

import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class LoginService {

    @Value("${login.url}")
    private String loginUrl;

    public Optional<LoginResponse> login(final LoginCredentialsForm credentials) {
        RestTemplate restTemplate = new RestTemplate();
        LoginResponse loginResponse = restTemplate.exchange(loginUrl, HttpMethod.POST,
                new HttpEntity<>(credentials), LoginResponse.class).getBody();
        loginResponse.setEmail(credentials.getEmail());
        return Optional.of(loginResponse);
    }
}
