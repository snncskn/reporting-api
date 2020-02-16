package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.TransactionsQueryForm;
import com.financialhouse.dto.form.response.TransactionsQueryResponse;
import com.financialhouse.service.TransactionQueryService;
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
@RequestMapping("/api/v3/transaction/list")
@RequiredArgsConstructor
public class TransactionQueryController extends BaseController {

    private final TransactionQueryService transactionQueryService;

    @PostMapping
    public RestResponse<TransactionsQueryResponse> transactionQuery(
            @RequestBody @Valid final TransactionsQueryForm reportForm) {
        log.info("/api/v3/transaction/list called...");
        return transactionQueryService.transactionQuery(reportForm).map(this::approved).orElseGet(this::declined);
    }
}
