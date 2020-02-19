package com.financialhouse.security.filter;

import com.financialhouse.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public final class AuthorizationFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String authHeader = request.getHeader("Authorization");

        /**
         * Guest access for login etc.
         */
        if (Utils.isEmpty(authHeader)) {
            try {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } catch (IOException | ServletException e) {
                log.error("filterChain -> {}", e.getMessage());
            }
        }

        final AuthorizationToken authToken = AuthorizationToken.builder().details(authHeader).build();
        SecurityContextHolder.getContext().setAuthentication(authToken);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IOException | ServletException e) {
            log.error("filterChain -> {}", e.getMessage());
        }

    }

}
