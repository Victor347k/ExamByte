package com.exambyte.exambyte.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testCorrectionEndpointRequiresKorrektorRole() throws Exception {
        mockMvc.perform(get("/correction"))
                .andExpect(status().is3xxRedirection());
    }

    @WithMockUser(username = "korrektor1", roles = {"Korrektor"})
    @Test
    void testKorrektorCanAccessCorrection() throws Exception {
        mockMvc.perform(get("/correction"))
                .andExpect(status().isOk());
    }

    @WithMockUser(username = "student1", roles = {"STUDENT"})
    @Test
    void testStudentCannotAccessCorrection() throws Exception {
        mockMvc.perform(get("/correction"))
                .andExpect(status().isForbidden());
    }

    @WithMockUser(username = "organisator1", roles = {"Organisator"})
    @Test
    void testOrganisatorCanAccessResults() throws Exception {
        mockMvc.perform(get("/results"))
                .andExpect(status().isOk());
    }

    @WithMockUser(username = "korrektor1", roles = {"Korrektor"})
    @Test
    void testKorrektorCannotAccessResults() throws Exception {
        mockMvc.perform(get("/results"))
                .andExpect(status().isForbidden());
    }

    @WithMockUser(username = "student1", roles = {"STUDENT"})
    @Test
    void testStudentCannotAccessTestManagement() throws Exception {
        mockMvc.perform(get("/test-management"))
                .andExpect(status().isForbidden());
    }
}
