package com.financialhouse.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author Sinan
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T> extends org.springframework.http.ResponseEntity<T> {
    public Response(final T body, final HttpStatus status) {
        super(body, status);
    }
}
