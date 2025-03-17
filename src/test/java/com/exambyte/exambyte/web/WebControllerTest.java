package com.exambyte.exambyte.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testIndexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    void testTestPage() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(view().name("test"));
    }

    @WithMockUser(username = "korrektor1", roles = {"Korrektor"})
    @Test
    void testCorrectionPage() throws Exception {
        mockMvc.perform(get("/correction"))
                .andExpect(status().isOk())
                .andExpect(view().name("correction"));
    }

    @WithMockUser(username = "organisator1", roles = {"Organisator"})
    @Test
    void testResultsPage() throws Exception {
        mockMvc.perform(get("/results"))
                .andExpect(status().isOk())
                .andExpect(view().name("results"));
    }
}
