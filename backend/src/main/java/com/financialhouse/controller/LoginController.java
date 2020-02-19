package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.response.LoginResponse;
import com.financialhouse.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Sinan
 * @apiNote Login step
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final LoginService loginService;

    /**
     * user/login
     *
     * @param form information from the FE side
     * @return RestResponse with status SUCCESS or ERROR and with body the data
     */
    @PostMapping(value = {"/login"})
    public RestResponse<LoginResponse> login(@RequestBody @Valid LoginCredentialsForm form) {
        log.info("api/login called with email {} - password {}", form.getEmail(), form.getPassword());
        return loginService.login(form).map(this::approved).orElseGet(this::declined);
    }

}
