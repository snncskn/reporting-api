package com.financialhouse.dto.form.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financialhouse.dto.enums.Operations;
import com.financialhouse.dto.enums.PaymentMethods;
import com.financialhouse.dto.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Sinan
 * <p>
 * <p>
 * { }
 * OR
 * {
 * "fromDate": "2015-07-01",
 * "toDate": "2015-10-01",
 * }
 * OR
 * {
 * "fromDate": "2015-07-01",
 * "toDate": "2015-10-01",
 * "merchant": 1,
 * "acquirer": 1,
 * }
 * REPORTING API DOCUMENTATION
 * 11
 * OR
 * {
 * "fromDate": "2015-07-01",
 * "toDate": "2015-10-01",
 * "merchantId": 1,
 * "acquirerId": 1,
 * "status": "APPROVED",
 * "operation": "DIRECT",
 * "paymentMethod": "CREDITCARD",
 * "filterField": "Reference No",
 * "filterValue": "1-1568845-56",
 * "page": 1
 * }
 * OR
 * {
 * " "status": "DECLINED",
 * "operation": "3D",
 * " errorCode": "Invalid Transaction"
 * }
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionsQueryForm extends HeaderParameters {

    /**
     * Start Date
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    /**
     * Finish Date
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String toDate;

    /**
     * The API request status.
     */
    private Status status;

    /**
     * Request operation
     */
    private Operations operation;

    /**
     * The merchant identifier.
     */
    private Integer merchantId;

    /**
     * The acquirer identifier.
     */
    private Integer acquirerId;

    /**
     * The payment method
     */
    private PaymentMethods paymentMethod;

    /**
     * Error Code
     */
    private String errorCode;

    /**
     * Search by special field
     */
    private String filterField;

    /**
     * Value of field.
     */
    private String filterValue;

    /**
     * Number of page
     */
    private Integer page;

}
