package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.TransactionsQueryForm;
import com.financialhouse.dto.form.request.TransactionsReportForm;
import com.financialhouse.dto.form.response.TransactionInfo;
import com.financialhouse.dto.form.response.TransactionReportResponse;
import com.financialhouse.dto.form.response.TransactionsQueryResponse;
import com.financialhouse.service.TransactionService;
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
public class TransactionController extends BaseController {

    private final TransactionService transactionService;

    /**
     * the form of the transactionReport to retrieve
     *
     * @param reportForm
     * @return RestResponse with status SUCCESS with body the data or ERROR
     */
    @PostMapping(value = {"/report"})
    public RestResponse<TransactionReportResponse> transactionReport(
            @RequestBody @Valid final TransactionsReportForm reportForm) {
        log.info("/api/report called with TransactionsReportForm {}", reportForm.toString());
        return transactionService.transactionReport(reportForm).map(this::approved).orElseGet(this::declined);
    }

    /**
     * POST with "TransactionsForm"
     *
     * @param queryForm
     * @return RestResponse with status SUCCESS with body the data or ERROR
     */
    @PostMapping(value = {"/list"})
    public RestResponse<TransactionsQueryResponse> transactionQuery(
            @RequestBody @Valid final TransactionsQueryForm queryForm) {
        log.info("/api/list called with TransactionsQueryForm {}", queryForm.toString());
        return transactionService.transactionQuery(queryForm).map(this::approved).orElseGet(this::declined);
    }


    /**
     * GET with "transactionId"
     *
     * @param transactionId
     * @return
     */
    @GetMapping(value = {"/{transactionId}"})
    public RestResponse<TransactionInfo> getTransaction(@PathVariable @NotNull String transactionId) {
        log.info("/api/transaction/{transactionId} called with Transaction : {}", transactionId);
        return transactionService.transactionInfo(transactionId).map(this::approved).orElseGet(this::declined);
    }

}
