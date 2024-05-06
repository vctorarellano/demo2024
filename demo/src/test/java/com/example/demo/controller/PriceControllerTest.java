package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPriceAt10AMOnDay14() throws Exception {
        mockMvc.perform(get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T10:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void testPriceAt4PMOnDay14() throws Exception {
        mockMvc.perform(get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T16:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void testPriceAt9PMOnDay14() throws Exception {
        mockMvc.perform(get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void testPriceAt10AMOnDay15() throws Exception {
        mockMvc.perform(get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-15T10:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void testPriceAt9PMOnDay16() throws Exception {
        mockMvc.perform(get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-16T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(38.95));
    }
    
    
}
