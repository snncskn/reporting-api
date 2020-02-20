package com.financialhouse.controller;

import com.financialhouse.ReportingApiApplication;
import com.financialhouse.dto.form.request.LoginCredentialsForm;
import com.financialhouse.security.filter.AuthorizationToken;
import com.financialhouse.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    public void getTransactionControllerWithTransactionId() throws Exception {
        mockMvc.perform(get("/api/transaction/{transactionId}", "1011028-1539357144-1293"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void getTransactionReportControllerWithTransactionsReportForm() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/transaction/report")
                .param("fromDate", "2015-01-01")
                .param("toDate", "2020-01-01");
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void getTransactionListControllerWithTransactionsQueryForm() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/transaction/list")
                .param("fromDate", "2015-01-01")
                .param("toDate", "2020-01-01");
        mockMvc.perform(builder).andExpect(status().isOk());
    }

}