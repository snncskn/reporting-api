package com.financialhouse.error_handling;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.error_handling.exception.AccessNotAllowedException;
import com.financialhouse.error_handling.exception.BadRequestException;
import com.financialhouse.error_handling.exception.ErrorOccurredException;
import com.financialhouse.util.RestResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandlingControllerAdvice {

    private final RestResponseFactory resp;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<RestResponse> defaultExceptionHandler(final Throwable ex,
                                                                final HttpServletRequest request,
                                                                final HttpServletResponse response) {

        if (response == null) {
            log.debug("An exception occurred", ex);
            return null;
        }

        // Overriding response type
        response.setContentType("application/json");

        log.error(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(
                resp.error("c01d5b769dfa", "error-occurred", ex.getLocalizedMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(AccessNotAllowedException.class)
    public ResponseEntity<RestResponse> handleException(final AccessNotAllowedException ex,
                                                        final HttpServletRequest request,
                                                        final HttpServletResponse response) {

        if (response == null) {
            log.debug("Access not allowed", ex);
            return null;
        }

        // Overriding response type
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "access-not-allowed";
        final String code = ex.getCode() == null ? "504a995889df" : ex.getCode();

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(code, messageText, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<RestResponse> handleException(final BadRequestException ex,
                                                 final HttpServletRequest request,
                                                 final HttpServletResponse response) {

        if (response == null) {
            log.debug("Bad request", ex);
            return null;
        }

        // Overriding response type
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "bad-request";
        final String code = ex.getCode() == null ? "aa5a48cdc383" : ex.getCode();

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(code, messageText, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ErrorOccurredException.class)
    ResponseEntity<RestResponse> handleException(final ErrorOccurredException ex,
                                                 final HttpServletRequest request,
                                                 final HttpServletResponse response) {

        if (response == null) {
            log.debug("An error occurred", ex);
            return null;
        }

        // Overriding response type
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "error-occurred";
        final String code = ex.getCode() == null ? "7ff7336b4b99" : ex.getCode();

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(messageText, code, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
