package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.TransactionsReportForm;
import com.financialhouse.dto.form.response.TransactionReportResponse;
import com.financialhouse.service.TransactionReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sinan
 */

@Slf4j
@RestController
@RequestMapping("/api/v3/transactions/report")
@RequiredArgsConstructor
public class TransactionReportController extends BaseController {

    private final TransactionReportService transactionReportService;

    @PostMapping
    public RestResponse<TransactionReportResponse> transactionReport(
            @RequestBody @Valid final TransactionsReportForm reportForm) {
        log.info("/api/v3/transactions/report called...");
        return transactionReportService.transactionReport(reportForm).map(this::approved).orElseGet(this::declined);
    }
}
