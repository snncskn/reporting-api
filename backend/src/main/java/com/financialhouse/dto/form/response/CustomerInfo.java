package com.financialhouse.dto.form.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * {
 *     "customerInfo": {
 *         "id": 706020,
 *         "created_at": "2018-09-20 09:09:04",
 *         "updated_at": "2018-09-20 09:09:04",
 *         "deleted_at": null,
 *         "number": "510139XXXXXX8174",
 *         "expiryMonth": "1",
 *         "expiryYear": "2020",
 *         "startMonth": null,
 *         "startYear": null,
 *         "issueNumber": null,
 *         "email": "test@bumin.io",
 *         "birthday": "1971-11-11 09:09:04",
 *         "gender": null,
 *         "billingTitle": "Mr.",
 *         "billingFirstName": "Foo",
 *         "billingLastName": "Bar",
 *         "billingCompany": "Test",
 *         "billingAddress1": "test",
 *         "billingAddress2": null,
 *         "billingCity": "ANTALYA",
 *         "billingPostcode": "07070",
 *         "billingState": "ANTALYA",
 *         "billingCountry": "TR",
 *         "billingPhone": "05554443322",
 *         "billingFax": null,
 *         "shippingTitle": "Mr.",
 *         "shippingFirstName": "Foo",
 *         "shippingLastName": "Bar",
 *         "shippingCompany": "Test",
 *         "shippingAddress1": "test",
 *         "shippingAddress2": null,
 *         "shippingCity": "ANTALYA",
 *         "shippingPostcode": "07070",
 *         "shippingState": "ANTALYA",
 *         "shippingCountry": "TR",
 *         "shippingPhone": "05554443322",
 *         "shippingFax": null,
 *         "token": null
 *     },
 *     "fx": {
 *         "merchant": {
 *             "originalAmount": 150,
 *             "originalCurrency": "TRY"
 *         }
 *     },
 *     "transaction": {
 *         "merchant": {
 *             "referenceNo": "trn-test-seck-1",
 *             "merchantId": 1293,
 *             "status": "ERROR",
 *             "channel": "API",
 *             "customData": null,
 *             "chainId": "5ba363b03bbe6",
 *             "type": "AUTH",
 *             "agentInfoId": 21897,
 *             "operation": "DIRECT",
 *             "updated_at": "2018-09-20 09:09:04",
 *             "created_at": "2018-09-20 09:09:04",
 *             "id": 1009728,
 *             "fxTransactionId": 1386823,
 *             "acquirerTransactionId": 1012191,
 *             "code": 150,
 *             "message": "Unable to connect to acquirer",
 *             "transactionId": "1009728-1537434544-1293",
 *             "agent": {
 *                 "id": 21897,
 *                 "customerIp": "37.155.25.89",
 *                 "customerUserAgent": "PostmanRuntime/7.3.0",
 *                 "merchantIp": "37.155.25.89",
 *                 "merchantUserAgent": "PostmanRuntime/7.3.0",
 *                 "created_at": "2018-09-20 09:09:04",
 *                 "updated_at": "2018-09-20 09:09:04",
 *                 "deleted_at": null
 *             }
 *         }
 *     },
 *     "merchant": {
 *         "name": "Seckin Merchant"
 *     }
 * }
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("deleted_at")
    private Date deletedAt;

    private String number;
    private String expiryMonth;
    private String expiryYear;
    private String startMonth;
    private String startYear;
    private String issueNumber;
    private String email;
    private String birthday;
    private String gender;
    private String billingTitle;
    private String billingFirstName;
    private String billingLastName;
    private String billingCompany;
    private String billingAddress1;
    private String billingAddress2;
    private String billingCity;
    private String billingPostcode;
    private String billingState;
    private String billingCountry;
    private String billingPhone;
    private String billingFax;
    private String shippingTitle;
    private String shippingFirstName;
    private String shippingLastName;
    private String shippingCompany;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingCity;
    private String shippingPostcode;
    private String shippingState;
    private String shippingCountry;
    private String shippingPhone;
    private String shippingFax;
}
