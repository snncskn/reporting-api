package com.financialhouse.util;

import org.springframework.http.HttpHeaders;

/**
 * @author Sinan
 */

public class HttpUtils {

    private static final String AUTHORIZATION = "Authorization";

    public static HttpHeaders addAuthorization(final String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(AUTHORIZATION, token);
        return headers;
    }
}
