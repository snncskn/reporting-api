package com.financialhouse.controller;

import com.financialhouse.dto.RestResponse;
import com.financialhouse.dto.form.request.TransactionsQueryForm;
import com.financialhouse.dto.form.request.TransactionsReportForm;
import com.financialhouse.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public RestResponse transactionReport(
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
    public RestResponse transactionQuery(
            @RequestBody @Valid final TransactionsQueryForm queryForm) {
        log.info("/api/list called with TransactionsQueryForm {}", queryForm.toString());
        return transactionService.transactionQuery(queryForm).map(this::approved).orElseGet(this::declined);
    }


    /**
     * GET with "transactionId"
     *
     * @param transactionId
     * @return RestResponse with status SUCCESS with body the data or ERROR
     */
    @GetMapping(value = {"/{transactionId}"})
    public RestResponse getTransaction(@PathVariable @NotNull final String transactionId) {
        log.info("/api/transaction/{transactionId} called with Transaction : {}", transactionId);
        return transactionService.transactionInfo(transactionId).map(this::approved).orElseGet(this::declined);
    }

}
