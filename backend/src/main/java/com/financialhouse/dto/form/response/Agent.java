package com.financialhouse.dto.form.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {

    private Integer id;
    private String customerIp;
    private String customerUserAgent;
    private String merchantIp;
    private String merchantUserAgent;

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

}
