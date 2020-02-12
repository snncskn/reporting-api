package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.LoginCredentialsForm;
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
 */


@Slf4j
@RestController
@RequestMapping("/api/v3/merchant/user/login")
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final LoginService loginService;

    @PostMapping
    public RestResponse login(@RequestBody @Valid final LoginCredentialsForm loginCredentialsForm) {

        log.debug("api/v3/merchant/user/login called...");

        return loginService.login(loginCredentialsForm)
                .map(authToken -> respFactory.success("18b7ed26d021", "login-success", authToken))
                .orElseGet(() -> respFactory.error("18b7ed26d021", "login-error"));
    }
}
