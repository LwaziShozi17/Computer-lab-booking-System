package za.ac.cput.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.Domain.Admin;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @Autowired
    private ObjectMapper objectMapper;

    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin();
        admin.setAdminId("A001");
        admin.setName("John Doe");
        admin.setEmail("john@example.com");
        admin.setRole("Super Admin");
    }

    @Test
    void testCreateAdmin() throws Exception {
        when(adminService.createAdmin(any(Admin.class))).thenReturn(admin);

        mockMvc.perform(post("/api/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.adminId").value("A001"))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void testGetAllAdmins() throws Exception {
        when(adminService.getAllAdmins()).thenReturn(Arrays.asList(admin));

        mockMvc.perform(get("/api/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].adminId").value("A001"));
    }

    @Test
    void testGetAdminById() throws Exception {
        when(adminService.getAdminById("A001")).thenReturn(Optional.of(admin));

        mockMvc.perform(get("/api/admin/A001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void testDeleteAdmin() throws Exception {
        mockMvc.perform(delete("/api/admin/A001"))
                .andExpect(status().isNoContent());
    }
}
