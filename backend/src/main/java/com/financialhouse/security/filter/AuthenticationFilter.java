package com.financialhouse.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Sinan
 */

@Slf4j
@Component
@RequiredArgsConstructor
public final class AuthenticationFilter // extends GenericFilterBean {
{

    /**
     * AuthenticationFilter
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     */
    // @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String authHeader = request.getHeader("Authorization");
        // Utils.isEmpty(authHeader).orElseThrow(() -> new BaseException("000001",""));
        log.debug("Authorization token -> {} ", authHeader);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IOException | ServletException e) {
            log.error("filterChain -> {}", e.getMessage());
        }

    }

}
