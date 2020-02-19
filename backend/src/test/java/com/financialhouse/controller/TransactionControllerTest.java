package com.financialhouse.controller;

import com.financialhouse.ReportingApiApplication;
import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.dto.form.request.TransactionsReportForm;
import com.financialhouse.security.filter.AuthorizationToken;
import com.financialhouse.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReportingApiApplication.class)
public class TransactionControllerTest {

    private final String email = "demo@financialhouse.io";
    private final String password = "cjaiU8CV";

    @Autowired
    private TransactionController controller;

    @Autowired
    private LoginService loginService;

    private MockMvc mockMvc;


    @Before
    public void setup() {

        final String token = loginService.login(
                LoginCredentialsForm.builder().email(email).password(password).build()).get().getToken();

        SecurityContextHolder.getContext().setAuthentication(AuthorizationToken.builder().details(token).build());

        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(this.controller).build();
    }

    @Test
    public void getTransactionController_WithTransactionId() throws Exception {
        mockMvc.perform(get("/api/transaction/{transactionId}",
                "1011028-1539357144-1293")).andExpect(status().isOk());

        mockMvc.perform(get("/api/transaction/{transactionId}",
                "1011028-000000-1293")).andExpect(status().isNotFound());

    }


    @Test
    public void getTransactionReportController_WithTransactionsReportForm() throws Exception {
        TransactionsReportForm reportForm = TransactionsReportForm.builder()
                .fromDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-01"))
                .toDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"))
                .build();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/transaction/report")
                .param("fromDate", "2015-01-01")
                .param("toDate", "2020-01-01");

        this.mockMvc.perform(builder).andExpect(status().isOk());


    }

}