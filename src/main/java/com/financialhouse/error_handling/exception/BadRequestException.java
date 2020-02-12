package com.financialhouse.error_handling.exception;

public class BadRequestException extends BaseException {

    public BadRequestException(final String code, final String message) {
        super(code, message);
    }
}
