package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import com.financialhouse.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sinan
 * @apiNote Login step
 */

@Slf4j
@RestController
@RequestMapping("/api/v3/merchant/user/login")
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final LoginService loginService;

    /**
     * user/login
     *
     * @param form information from the FE side
     * @return the RestResponse with status SUCCESS or ERROR and with body the data
     */
    @PostMapping
    public RestResponse<LoginResponse> login(@RequestBody @Valid final LoginCredentialsForm form) {
        log.info("api/v3/merchant/user/login called with email {} - password {}", form.getEmail(), form.getPassword());
        return loginService.login(form).map(this::approved).orElseGet(this::declined);
    }

}
