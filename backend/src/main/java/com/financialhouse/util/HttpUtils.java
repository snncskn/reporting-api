package com.financialhouse.util;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Sinan
 */

public class HttpUtils {

    private static final String AUTHORIZATION = "Authorization";

    public static HttpHeaders addAuthorization() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(AUTHORIZATION, SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
        return headers;
    }
}
