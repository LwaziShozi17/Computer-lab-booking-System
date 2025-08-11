package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void createAdmin_success() {
        Admin admin = AdminFactory.createAdmin(
                "John",
                "Doe",
                "john@example.com",
                "password123",
                "EMP001",
                List.of("CREATE_BOOKING", "DELETE_BOOKING")
        );

        assertNotNull(admin);
        assertNotNull(admin.getUserId());
        assertEquals("John", admin.getFirstName());
        assertEquals("Doe", admin.getLastName());
        assertEquals("john@example.com", admin.getEmail());
        assertEquals("EMP001", admin.getEmployeeId());
        assertTrue(admin.canPerform("CREATE_BOOKING"));
    }

    @Test
    void createAdmin_fail_missingFields() {
        Admin admin = AdminFactory.createAdmin(
                "", // Missing firstName
                "Doe",
                "john@example.com",
                "password123",
                "EMP001",
                List.of("CREATE_BOOKING")
        );
        assertNull(admin); // Factory should return null for invalid input
    }

    @Test
    void createAdmin_fail_invalidEmail() {
        Admin admin = AdminFactory.createAdmin(
                "John",
                "Doe",
                "invalid-email",
                "password123",
                "EMP001",
                List.of("CREATE_BOOKING")
        );
        assertNull(admin); // Factory should return null for invalid email
    }
}
