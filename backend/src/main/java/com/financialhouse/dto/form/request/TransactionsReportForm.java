package com.financialhouse.dto.form.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Sinan
 * <p>
 * "fromDate": "2015-07-01",
 * "toDate": "2015-10-01",
 * "merchant": 1,
 * "acquirer": 1,
 */

@Data
public class TransactionsReportForm {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "fromDate field is required")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "toDate field is required")
    private Date toDate;

    private Integer merchant;
    private Integer acquirer;

}
