package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void createAdmin_success() {
        Admin admin = AdminFactory.createAdmin(
                "John Doe",
                "john@example.com",
                "System Administrator",
                Arrays.asList("CREATE_BOOKING", "DELETE_BOOKING")
        );

        assertNotNull(admin);
        assertNotNull(admin.getAdminId());
        assertEquals("John Doe", admin.getName());
        assertEquals("john@example.com", admin.getEmail());
        assertTrue(admin.canPerform("CREATE_BOOKING"));
    }

    @Test
    void createAdmin_fail_missingFields() {
        Admin admin = AdminFactory.createAdmin(
                "", // Missing name
                "john@example.com",
                "System Administrator",
                Arrays.asList("CREATE_BOOKING")
        );
        assertNull(admin); // Factory should return null for invalid input
    }
}
