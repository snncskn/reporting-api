package com.financialhouse.util;

import com.financialhouse.dto.RestResponse;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public final class RestResponseFactory {

    private final MessageSource messageSource;

    public RestResponseFactory(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public RestResponse error(final String msgId, final Object data) {
        return createMessage("ERROR", msgId, data);
    }

    public RestResponse error(final String msgId) {
        return createMessage("ERROR", msgId, null);
    }


    public RestResponse success(final String msgId, final Object data) {
        return createMessage("SUCCESS", msgId, data);
    }

    private <T> RestResponse createMessage(final String type, final String msgId, final T data) {
        final RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setType(type);
        restResponse.setText(messageSource.getMessage(msgId, null, msgId, Locale.getDefault()));
        restResponse.setData(data);
        return restResponse;
    }
}
