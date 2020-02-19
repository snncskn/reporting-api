package com.financialhouse.service;

import com.financialhouse.dto.form.request.TransactionsQueryForm;
import com.financialhouse.dto.form.request.TransactionsReportForm;
import com.financialhouse.dto.form.response.TransactionInfo;
import com.financialhouse.dto.form.response.TransactionReportResponse;
import com.financialhouse.dto.form.response.TransactionsQueryResponse;
import com.financialhouse.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sinan
 */

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final HttpUtils httpUtils;

    @Value("${transaction.query.url}")
    private String transactionQueryUrl;

    @Value("${transaction.getInfo.url}")
    private String transactionGetInfoUrl;

    @Value("${transaction.report.url}")
    private String transactionReportUrl;

    /**
     * @param form
     * @return
     */
    public Optional<TransactionReportResponse> transactionReport(final TransactionsReportForm form) {
        return Optional.of(httpUtils.post(transactionReportUrl, form, TransactionReportResponse.class));
    }

    /**
     * @param form
     * @return
     */
    public Optional<TransactionsQueryResponse> transactionQuery(final TransactionsQueryForm form) {
        return Optional.of(httpUtils.post(transactionQueryUrl, form, TransactionsQueryResponse.class));
    }

    /**
     * @param transactionId
     * @return
     */
    public Optional<TransactionInfo> transactionInfo(final String transactionId) {
        return Optional.of(httpUtils.get(transactionGetInfoUrl, transactionId, TransactionInfo.class));
    }
}
