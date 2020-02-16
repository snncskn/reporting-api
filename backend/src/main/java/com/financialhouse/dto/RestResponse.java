package com.financialhouse.dto;

import lombok.Data;

@Data
public class RestResponse<T> {
    private T data;
    private String text;
    private String type;
}

