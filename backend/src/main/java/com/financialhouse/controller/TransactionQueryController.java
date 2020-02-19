package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.TransactionsQueryForm;
import com.financialhouse.dto.form.response.TransactionInfo;
import com.financialhouse.dto.form.response.TransactionsQueryResponse;
import com.financialhouse.service.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Sinan
 */

@Slf4j
@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionQueryController extends BaseController {

    private final TransactionQueryService transactionQueryService;

    /**
     * POST with "TransactionsQueryForm"
     *
     * @param queryForm
     * @return
     */
    @PostMapping("/list")
    public RestResponse<TransactionsQueryResponse> transactionQuery(
            @RequestBody @Valid final TransactionsQueryForm queryForm) {
        log.info("/api/transaction/list called with TransactionsQueryForm...");
        return transactionQueryService.transactionQuery(queryForm).map(this::approved).orElseGet(this::declined);
    }


    /**
     * GET with "transactionId"
     *
     * @param transactionId
     * @return
     */
    @GetMapping("/{transactionId}")
    public RestResponse<TransactionInfo> getTransaction(@PathVariable @NotNull String transactionId) {
        log.info("/api/v3/transaction called with Transaction : {}", transactionId);
        return transactionQueryService.transactionInfo(transactionId).map(this::approved).orElseGet(this::declined);
    }
}
