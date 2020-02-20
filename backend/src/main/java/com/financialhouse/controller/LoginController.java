package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Sinan
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final LoginService loginService;

    /**
     * /login -> used to login to the api
     *
     * @param form information from the FE side
     * @return RestResponse with status SUCCESS with body the data or ERROR
     */
    @PostMapping(value = {"/login"})
    public RestResponse login(@RequestBody @Valid final LoginCredentialsForm form) {
        log.info("api/login called with email {} - password {}", form.getEmail(), form.getPassword());
        return loginService.login(form).map(this::approved).orElseGet(this::declined);
    }

}
