package com.qinshift.transportCompany.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CompanyControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private final String companyJson = "{\"id\":\"777\", \"name\":\"Jug-Ekspres\",\"location\":\"Leskovac, RS\",\"founded\":\"1960\"}";

    private final int companyId = 777;

    private void createCompany() throws Exception {
        mockMvc.perform(post("/apiFirst/companies/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(companyJson));
    }

    @Test
    public void testGetById() throws Exception {
        createCompany();
        ResultActions result = mockMvc.perform(get("/apiFirst/companies/{id}", companyId));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(companyId))
                .andExpect(jsonPath("$.name").value("Jug-Ekspres"))
                .andExpect(jsonPath("$.location").value("Leskovac, RS"))
                .andExpect(jsonPath("$.founded").value("1960"));
    }

    @Test
    public void testCreate() throws Exception {
        ResultActions result = mockMvc.perform(post("/apiFirst/companies/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(companyJson));

        result.andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        createCompany();
        String updateJson =  "{\"id\":\"777\", \"name\":\"Nis-Ekspres\",\"location\":\"Nis, RS\",\"founded\":\"1951\"}";

        ResultActions result = mockMvc.perform(put("/apiFirst/companies/{id}", companyId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJson));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(companyId))
                .andExpect(jsonPath("$.name").value("Nis-Ekspres"))
                .andExpect(jsonPath("$.location").value("Nis, RS"))
                .andExpect(jsonPath("$.founded").value(1951));
    }

    @Test
    public void testDeleteUser() throws Exception {
        createCompany();
        ResultActions result = mockMvc.perform(delete("/apiFirst/companies/{id}", companyId));

        result.andExpect(status().isNoContent())
                .andExpect(content().string("Successfully deleted"));
    }

    @Test
    public void testGetAll() throws Exception {
        ResultActions result = mockMvc.perform(get("/apiFirst/companies"));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
