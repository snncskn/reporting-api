package com.financialhouse.service;

import com.financialhouse.dto.form.request.TransactionsReportForm;
import com.financialhouse.dto.form.response.TransactionReportResponse;
import com.financialhouse.util.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TransactionReportService {

    @Value("${transaction.report.url}")
    private String transactionReportUrl;

    public Optional<TransactionReportResponse> transactionReport(final TransactionsReportForm form) {

        RestTemplate restTemplate = new RestTemplate();
        TransactionReportResponse response = restTemplate.exchange(transactionReportUrl, HttpMethod.POST,
                new HttpEntity<>(form, HttpUtils.addAuthorization(form.getToken())),
                TransactionReportResponse.class).getBody();

        return Optional.of(response);
    }

}
