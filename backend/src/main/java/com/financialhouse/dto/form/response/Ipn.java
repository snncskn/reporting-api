package com.financialhouse.dto.form.response;

import lombok.Data;

@Data
public class Ipn {
    private boolean sent;
    private Merchant merchant;
}
