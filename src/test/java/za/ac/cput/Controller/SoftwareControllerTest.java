package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Software;
import za.ac.cput.Factory.SoftwareFactory;

import java.util.Optional;

/* Sithandiwe Ntombela 221805265 */


import static org.junit.jupiter.api.Assertions.*;

class SoftwareControllerTest {
    private SoftwareController controller;
    private Software software;

    @BeforeEach
    void setUp() {
        controller = new SoftwareController();
        software = SoftwareFactory.createSoftware(
                "SW-001",
                "IntelliJ IDEA",
                "2023.2",
                "Commercial"
        );
    }

    @Test
    @Order(1)
    void addSoftware() {
        controller.addSoftware(software);
        assertEquals(1, controller.getAllSoftware().size());
        System.out.println("Added software: " + software);
    }

    @Test
    @Order(2)
    void getSoftwareById() {
        controller.addSoftware(software);
        Optional<Software> found = controller.getSoftwareById("SW-001");
        assertTrue(found.isPresent());
        System.out.println("Found software: " + found.get());
    }

    @Test
    @Order(3)
    void updateSoftware() {
        controller.addSoftware(software);
        Software updated = new Software.Builder()
                .copy(software)
                .setVersion("2023.3")
                .build();

        controller.updateSoftware("SW-001", updated);
        assertEquals("2023.3",
                controller.getSoftwareById("SW-001").get().getVersion());
        System.out.println("Updated software: " + updated);
    }

    @Test
    @Order(4)
    void deleteSoftware() {
        controller.addSoftware(software);
        controller.deleteSoftware("SW-001");
        assertEquals(0, controller.getAllSoftware().size());
        System.out.println("Software deleted");
    }

    @Test
    @Order(5)
    void getAllSoftware() {
        controller.addSoftware(software);
        assertEquals(1, controller.getAllSoftware().size());
        System.out.println("All software: " + controller.getAllSoftware());
    }
}