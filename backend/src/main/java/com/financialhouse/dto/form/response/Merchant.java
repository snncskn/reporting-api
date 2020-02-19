package com.financialhouse.dto.form.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Merchant {

    private Integer originalAmount;
    private String originalCurrency;
    private Integer convertedAmount;
    private String convertedCurrency;
    private String referenceNo;
    private String status;
    private String customData;
    private String type;
    private String operation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created-at")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private Date updatedAt;

    private String message;
    private String transactionId;
    private Integer id;
    private String name;
    private boolean allowPartialRefund;
    private boolean allowPartialCapture;
    private Integer amount;
    private String currency;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private String code;
    private String chainId;
    private String paymentType;
    private String token;

    @JsonProperty("IPNUrl")
    private String ipnUrl;
    private String ipnType;

    private Agent agent;
    private Long acquirerTransactionId;
    private Long fxTransactionId;
    private Integer agentInfoId;
    private Integer merchantId;
    private String channel;

}
