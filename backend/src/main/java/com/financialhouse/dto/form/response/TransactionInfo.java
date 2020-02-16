package com.financialhouse.dto.form.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionInfo {

    private CustomerInfo customerInfo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private Date createdAt;

    private Fx fx;

    private Acquirer acquirer;

    private Transaction transaction;

    private boolean refundable = false;

    private Merchant merchant;

    private Ipn ipn;

}
