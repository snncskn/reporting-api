package com.financialhouse.error_handling;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.error_handling.exception.BadRequestException;
import com.financialhouse.error_handling.exception.TokenExpireException;
import com.financialhouse.util.RestResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandlingControllerAdvice {

    private final RestResponseFactory resp;

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<RestResponse> handleException(final HttpServerErrorException ex,
                                                        final HttpServletRequest request,
                                                        final HttpServletResponse response) {
        if (response == null) {
            log.debug("http-server-error", ex);
            return null;
        }
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "http-server-error";
        final String code = ex.getStatusCode() == null ? "504a995889df" : ex.getStatusCode().toString();

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(messageText, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<RestResponse> handleException(final BadRequestException ex,
                                                 final HttpServletRequest request,
                                                 final HttpServletResponse response) {
        if (response == null) {
            log.debug("Bad request", ex);
            return null;
        }
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "bad-request";

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(messageText, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<RestResponse> handleException(final HttpClientErrorException ex,
                                                 final HttpServletRequest request,
                                                 final HttpServletResponse response) {
        if (response == null) {
            log.debug("token-expired", ex);
            return null;
        }
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "token-expired";

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(messageText, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<RestResponse> defaultExceptionHandler(final Throwable ex,
                                                                final HttpServletRequest request,
                                                                final HttpServletResponse response) {
        if (response == null) {
            log.debug("An exception occurred", ex);
            return null;
        }
        response.setContentType("application/json");
        log.error(ErrorUtils.exceptionToString(ex, request));
        return new ResponseEntity<>(
                resp.error("error-occurred", ex.getLocalizedMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenExpireException.class)
    ResponseEntity<RestResponse> handleException(final TokenExpireException ex,
                                                 final HttpServletRequest request,
                                                 final HttpServletResponse response) {
        if (response == null) {
            log.debug("token-expire", ex);
            return null;
        }
        response.setContentType("application/json");

        final String exceptionMessage = ex.getMessage();
        final String messageText = exceptionMessage != null ? exceptionMessage : "token-expire";

        log.info(ErrorUtils.exceptionToString(ex, request));

        return new ResponseEntity<>(resp.error(messageText, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

}
