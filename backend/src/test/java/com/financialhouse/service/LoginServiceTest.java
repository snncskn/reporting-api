package com.financialhouse.service;

import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    private final String email = "demo@financialhouse.io";
    private final String password = "cjaiU8CV";

    @Test
    public void getLoginRequestLoggedInAndShouldReturnToken() {
        LoginCredentialsForm form = LoginCredentialsForm.builder().email(email).password(password).build();
        Optional<LoginResponse> response = loginService.login(form);
        assertThat(response).isNotNull().matches(x -> x.get().getStatus().equals("APPROVED"));
        assertNotNull("Authorization Token ", response.get().getToken());
    }

}