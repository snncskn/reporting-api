package com.financialhouse.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sinan
 */

@Slf4j
@Component
public class HttpUtils {

    private static final String AUTHORIZATION = "Authorization";

    @Value("${restService.timeout}")
    private Integer defTimeout;

    private HttpHeaders addAuthorization() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(AUTHORIZATION, SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
        return headers;
    }

    public <E> E post(final String url, final Object request, final Class<E> responseType) {
        return post(url, new HttpEntity<>(request, addAuthorization()), responseType);
    }

    public <E> E postForLogin(final String url, final Object request, final Class<E> responseType) {
        return this.post(url, new HttpEntity<>(request), responseType);
    }

    /**
     * Send a POST request to the given Url.
     *
     * @param url
     * @param responseType
     * @param <E>
     * @return
     */
    public <E> E post(final String url, final HttpEntity httpEntity, final Class<E> responseType) {
        log.debug("Post --> {}", url);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        HttpComponentsClientHttpRequestFactory rf =
                (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
        rf.setReadTimeout(defTimeout * 1000);
        rf.setConnectTimeout(defTimeout * 1000);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType).getBody();
    }

    /**
     * Send a GET request to the given Url.
     *
     * @param url
     * @param responseType
     * @param <E>
     * @return
     */
    public <E> E get(final String url, final Object request, final Class<E> responseType) {
        log.debug("Get --> {}", url);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        HttpComponentsClientHttpRequestFactory rf =
                (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
        rf.setReadTimeout(defTimeout * 1000);
        rf.setConnectTimeout(defTimeout * 1000);
        HttpEntity<Object> httpEntity = new HttpEntity<>(request, addAuthorization());
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType).getBody();
    }

}
