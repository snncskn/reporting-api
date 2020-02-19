package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.util.RestResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinan
 *
 * @apiNote RestResponse with api-success or api-error message with data
 */

abstract class BaseController {

    @Autowired
    public RestResponseFactory respFactory;

    public <T> RestResponse approved(final T data) {
        return respFactory.success("api-success", data);
    }

    public RestResponse declined() {
        return respFactory.error("api-error");
    }

}
