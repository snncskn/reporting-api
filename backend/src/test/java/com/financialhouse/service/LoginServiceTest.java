package com.financialhouse.service;

import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @MockBean
    private RestTemplate template;


    @Test
    public void whenLoginRequest_LoggedIn() {
        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity(
                new LoginResponse("eyJ0eXAiOiJKV1QiLCJhb", "APPROVED", "qqq@qqq.com"),
                HttpStatus.OK);

        when(template.postForEntity(any(String.class), new LoginCredentialsForm(any(), any()), LoginResponse.class)).
                thenReturn(responseEntity);

        Optional<LoginResponse> response =
                loginService.login(LoginCredentialsForm.builder().email("").password("").build());
        assertThat(response).isNotNull().matches(resp -> resp.get().getStatus().equals("APPROVED"));
    }


}