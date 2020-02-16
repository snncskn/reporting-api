package com.financialhouse.service;

import com.financialhouse.util.HttpUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sinan
 */

@Service
public final class RestService {

    public <T> Object post(String url, Class requestClass, Class responseClass, String authToken) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST,
                new HttpEntity<>(requestClass, HttpUtils.addAuthorization(authToken)), responseClass).getBody();
    }

}
