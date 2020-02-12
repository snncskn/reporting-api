package com.financialhouse.controller;


import com.financialhouse.util.RestResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinan
 */

public abstract class BaseController {
    @Autowired
    public RestResponseFactory respFactory;
}