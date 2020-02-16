package com.financialhouse.dto.form.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReportResponse {

    /**
     * The API request status.
     */
    private String status;

    @JsonProperty("response")
    private List<TransactionReport> transactionReports;

}
