package za.ac.cput.Service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Maintenance;
import za.ac.cput.Factory.MaintenanceFactory;

/* Sithandiwe Ntombela 221805265 */


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MaintenanceServiceTest {

    @Autowired
    private MaintenanceService service;

    private Maintenance maintenance;

    @BeforeEach
    void setUp() {
        maintenance = MaintenanceFactory.createMaintenance(
                "MT-001",
                "SW-001",
                "2023-10-25",
                "Routine maintenance check"
        );
    }

    @Test
    @Order(1)
    void saveMaintenance() {
        Maintenance saved = service.saveMaintenance(maintenance);
        assertNotNull(saved);
        System.out.println("Saved maintenance: " + saved);
    }

    @Test
    @Order(2)
    void findMaintenanceById() {
        service.saveMaintenance(maintenance);
        Optional<Maintenance> found = service.findMaintenanceById("MT-001");
        assertTrue(found.isPresent());
        System.out.println("Found maintenance: " + found.get());
    }

    @Test
    @Order(3)
    void getAllMaintenance() {
        service.saveMaintenance(maintenance);
        List<Maintenance> allMaintenance = service.getAllMaintenance();
        assertFalse(allMaintenance.isEmpty());
        System.out.println("All maintenance records: " + allMaintenance);
    }

    @Test
    @Order(4)
    void getMaintenanceBySoftwareId() {
        service.saveMaintenance(maintenance);
        List<Maintenance> bySoftware = service.getMaintenanceBySoftwareId("SW-001");
        assertFalse(bySoftware.isEmpty());
        System.out.println("Maintenance by software ID: " + bySoftware);
    }

    @Test
    @Order(5)
    void getMaintenanceByDate() {
        service.saveMaintenance(maintenance);
        List<Maintenance> byDate = service.getMaintenanceByDate("2023-10-25");
        assertFalse(byDate.isEmpty());
        System.out.println("Maintenance by date: " + byDate);
    }

    @Test
    @Order(6)
    void searchMaintenanceByDescription() {
        service.saveMaintenance(maintenance);
        List<Maintenance> byDesc = service.searchMaintenanceByDescription("Routine");
        assertFalse(byDesc.isEmpty());
        System.out.println("Maintenance by description: " + byDesc);
    }

    @Test
    @Order(7)
    void deleteMaintenance() {
        service.saveMaintenance(maintenance);
        service.deleteMaintenance("MT-001");
        Optional<Maintenance> deleted = service.findMaintenanceById("MT-001");
        assertTrue(deleted.isEmpty());
        System.out.println("Maintenance deleted successfully");
    }
}