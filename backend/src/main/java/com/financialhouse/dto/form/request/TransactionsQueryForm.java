package com.financialhouse.dto.form.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financialhouse.dto.enums.Operations;
import com.financialhouse.dto.enums.PaymentMethods;
import com.financialhouse.dto.enums.Status;
import lombok.Builder;
import lombok.Data;
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
@Builder
public class TransactionsQueryForm {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    private Status status;
    private Operations operation;
    private Integer merchantId;
    private Integer acquirerId;
    private PaymentMethods paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private Integer page;

}
