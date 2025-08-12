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
import za.ac.cput.service.AdminService;

import java.util.List;
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
        admin = new Admin.Builder()
                .setUserId("A001")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john@example.com")
                .setPassword("password123")
                .setEmployeeId("EMP001")
                .setPermissions(List.of("CREATE_BOOKING", "DELETE_BOOKING"))
                .build();
    }

    @Test
    void testCreateAdmin() throws Exception {
        when(adminService.create(any(Admin.class))).thenReturn(admin);

        mockMvc.perform(post("/admins")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value("A001"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    void testGetAllAdmins() throws Exception {
        when(adminService.getAll()).thenReturn(List.of(admin));

        mockMvc.perform(get("/admins"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value("A001"));
    }

    @Test
    void testGetAdminById() throws Exception {
        when(adminService.read("A001")).thenReturn(Optional.of(admin));

        mockMvc.perform(get("/admins/A001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    void testDeleteAdmin() throws Exception {
        mockMvc.perform(delete("/admins/A001"))
                .andExpect(status().isNoContent());
    }
}
