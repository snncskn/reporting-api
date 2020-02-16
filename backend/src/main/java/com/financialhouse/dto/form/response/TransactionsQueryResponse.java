package com.financialhouse.dto.form.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsQueryResponse {

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private Integer from;
    private Integer to;

    @JsonProperty("data")
    private List<TransactionInfo> transactionInfos;

}
