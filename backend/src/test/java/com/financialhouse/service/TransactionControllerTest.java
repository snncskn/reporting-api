package com.financialhouse.service;

import com.financialhouse.ReportingApiApplication;
import com.financialhouse.controller.TransactionController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReportingApiApplication.class)
public class TransactionControllerTest {

    @Autowired
    private TransactionController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(this.controller).build();
    }

    @Test
    public void getNonExistingCustomerInfo() throws Exception {
        mockMvc.perform(get("/api/transaction/{transactionId}", "1011028-1539357144-1293"))
                .andExpect(status().isNotFound()).
                andExpect(jsonPath("$.status").value("NOT_FOUND"));
    }

}