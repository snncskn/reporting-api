package com.financialhouse.error_handling;

import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Collectors;

final class ErrorUtils {

    private static final String STACK_TRACE_SEPARATOR = "Stack Trace ---------------------------------------\n";

    private ErrorUtils() {
    }

    static String exceptionToString(final Throwable ex, final HttpServletRequest request) {

        return requestToString(request) +
                STACK_TRACE_SEPARATOR +
                ExceptionUtils.getStackTrace(ex);
    }


    private static String requestToString(final HttpServletRequest request) {

        final StringBuilder errorMessage = new StringBuilder();
        final String requestURI = request.getRequestURI();

        errorMessage
                .append("\n")
                .append("Request -------------------------------------------\n")
                .append("Path: ").append(requestURI).append("\n")
                .append("Method: ").append(request.getMethod()).append("\n");

        final String queryString = request.getQueryString();

        if (queryString != null) {

            errorMessage
                    .append("Query String: ").append(queryString).append("\n")
                    .append("Parameters: ")
                    .append(
                            Collections.list(request.getParameterNames())
                                    .stream()
                                    .map(pn -> pn + ":" + request.getParameter(pn))
                                    .collect(Collectors.toList())
                    )
                    .append("\n");
        }

        errorMessage.append("Headers -------------------------------------------\n");

        final Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            final String headerName = headerNames.nextElement();
            final String headerContent = request.getHeader(headerName);

            errorMessage.append(headerName).append(": ").append(headerContent).append("\n");
        }

        try {

            final String content = request
                    .getReader()
                    .lines()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();

            errorMessage.append("Content -------------------------------------------\n").append(content);
        } catch (Exception e) {
            // pass
        }

        return errorMessage.toString();
    }
}
