package com.financialhouse.service;

import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.TransactionInfo;
import com.financialhouse.security.filter.AuthorizationToken;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceTest {

    private final String email = "demo@financialhouse.io";
    private final String password = "cjaiU8CV";

    @Autowired
    private LoginService loginService;

    @Autowired
    private TransactionService transactionService;

    private String token;

    @Before
    public void setUp() {
        token = loginService.login(LoginCredentialsForm.builder()
                .email(email).password(password).build()).get().getToken();
        SecurityContextHolder.getContext().setAuthentication(AuthorizationToken.builder().details(token).build());
    }

    @Test
    public void getTransactionInfo_WithTransactionId() {
        Optional<TransactionInfo> info = transactionService.transactionInfo("1011028-1539357144-1293");
        assertThat(info.get());
    }


}
