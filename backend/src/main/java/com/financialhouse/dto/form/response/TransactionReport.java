package com.financialhouse.dto.form.response;

import lombok.Data;

@Data
public class TransactionReport {

    /**
     * Quantity transaction
     */
    private Integer count;

    /**
     * Total amount
     **/
    private Long total;

    /**
     * Original currency
     */
    private String currency;

}
