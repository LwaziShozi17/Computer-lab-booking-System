/* AdminFactoryTest.java
 * Unit test for AdminFactory
 * Author: Lwazi Shozi (Student No: 230220061)
 * Date: 14 June 2025
 */
package za.ac.cput.factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    private List<String> testPermissions;
    @BeforeEach
    void setUp() {
        testPermissions = Arrays.asList("MANAGE_USERS", "VIEW_REPORTS");
    }
    @Test
    void testCreateAdmin() {
        Admin admin = AdminFactory.createAdmin(
                "Lwazi Shozi",
                "230220061@cput.ac.za",
                "System Admin",
                testPermissions
        );

        assertNotNull(admin);
        assertEquals("Lwazi Shozi", admin.getName());
        assertEquals("230220061@cput.ac.za", admin.getEmail());
        assertEquals("System Admin", admin.getRole());
        assertEquals(testPermissions, admin.getPermissions());
    }

    @Test
    void testAdminPermissions() {
        Admin admin = AdminFactory.createAdmin(
                "Admin Tester",
                "admin@test.com",
                "Tester",
                testPermissions
        );

        assertTrue(admin.canPerform("MANAGE_USERS"));
        assertFalse(admin.canPerform("DELETE_SYSTEM"));
    }

    @Test
    void testUniqueAdminId() {
        Admin admin1 = AdminFactory.createAdmin("User1", "u1@test.com", "Role1", testPermissions);
        Admin admin2 = AdminFactory.createAdmin("User2", "u2@test.com", "Role2", testPermissions);
        assertNotEquals(admin1.getAdminId(), admin2.getAdminId(), "Admin IDs should be unique");
    }
}
