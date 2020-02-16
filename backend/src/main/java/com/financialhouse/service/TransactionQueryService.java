package com.financialhouse.service;

import com.financialhouse.dto.form.request.TransactionsQueryForm;
import com.financialhouse.dto.form.response.TransactionsQueryResponse;
import com.financialhouse.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionQueryService extends BaseService {

    @Value("${transaction.query.url}")
    private String transactionQueryUrl;

    public Optional<TransactionsQueryResponse> transactionQuery(final TransactionsQueryForm form) {

        RestTemplate restTemplate = new RestTemplate();
        TransactionsQueryResponse response = restTemplate.exchange(transactionQueryUrl,
                HttpMethod.POST, new HttpEntity<>(form, HttpUtils.addAuthorization(form.getToken())),
                TransactionsQueryResponse.class).getBody();

        return Optional.of(response);
    }

}
