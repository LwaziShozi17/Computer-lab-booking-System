package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Maintenance;
import za.ac.cput.Factory.MaintenanceFactory;

import java.util.Optional;

/* Sithandiwe Ntombela 221805265 */


import static org.junit.jupiter.api.Assertions.*;

class MaintenanceControllerTest {
    private MaintenanceController controller;
    private Maintenance maintenance;

    @BeforeEach
    void setUp() {
        controller = new MaintenanceController();
        maintenance = MaintenanceFactory.createMaintenance(
                "MT-001",
                "SW-001",
                "2023-10-25",
                "Routine check"
        );
    }

    @Test
    @Order(1)
    void addMaintenance() {
        controller.addMaintenance(maintenance);
        assertEquals(1, controller.getAllMaintenance().size());
        System.out.println("Added maintenance: " + maintenance);
    }

    @Test
    @Order(2)
    void getMaintenanceById() {
        controller.addMaintenance(maintenance);
        Optional<Maintenance> found = controller.getMaintenanceById("MT-001");
        assertTrue(found.isPresent());
        System.out.println("Found maintenance: " + found.get());
    }

    @Test
    @Order(3)
    void updateMaintenance() {
        controller.addMaintenance(maintenance);
        Maintenance updated = new Maintenance.Builder()
                .copy(maintenance)
                .setDescription("Urgent repair")
                .build();

        controller.updateMaintenance("MT-001", updated);
        assertEquals("Urgent repair",
                controller.getMaintenanceById("MT-001").get().getDescription());
        System.out.println("Updated maintenance: " + updated);
    }

    @Test
    @Order(4)
    void deleteMaintenance() {
        controller.addMaintenance(maintenance);
        controller.deleteMaintenance("MT-001");
        assertEquals(0, controller.getAllMaintenance().size());
        System.out.println("Maintenance deleted");
    }

    @Test
    @Order(5)
    void getAllMaintenance() {
        controller.addMaintenance(maintenance);
        assertEquals(1, controller.getAllMaintenance().size());
        System.out.println("All maintenance records: " +
                controller.getAllMaintenance());
    }
}