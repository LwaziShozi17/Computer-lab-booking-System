package za.ac.cput.Service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Software;
import za.ac.cput.Factory.SoftwareFactory;

/* Sithandiwe Ntombela 221805265 */
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SoftwareServiceTest {

    @Autowired
    private za.ac.cput.Service.SoftwareService service;

    private Software software;

    @BeforeEach
    void setUp() {
        software = SoftwareFactory.createSoftware(
                "SW-001",
                "IntelliJ IDEA",
                "2023.2",
                "Commercial"
        );
    }

    @Test
    @Order(1)
    void saveSoftware() {
        Software saved = service.saveSoftware(software);
        assertNotNull(saved);
        assertEquals("SW-001", saved.getSoftwareId());
        System.out.println("Saved: " + saved);
    }

    @Test
    @Order(2)
    void findSoftwareById() {
        service.saveSoftware(software);
        Optional<Software> found = service.findSoftwareById("SW-001");
        assertTrue(found.isPresent());
        System.out.println("Found: " + found.get());
    }

    @Test
    @Order(3)
    void getAllSoftware() {
        service.saveSoftware(software);
        List<Software> allSoftware = service.getAllSoftware();
        assertFalse(allSoftware.isEmpty());
        System.out.println("All Software: " + allSoftware);
    }

    @Test
    @Order(4)
    void getSoftwareByName() {
        service.saveSoftware(software);
        List<Software> byName = service.getSoftwareByName("IntelliJ IDEA");
        assertFalse(byName.isEmpty());
        System.out.println("By Name: " + byName);
    }

    @Test
    @Order(5)
    void getSoftwareByVersion() {
        service.saveSoftware(software);
        List<Software> byVersion = service.getSoftwareByVersion("2023.2");
        assertFalse(byVersion.isEmpty());
        System.out.println("By Version: " + byVersion);
    }

    @Test
    @Order(6)
    void getSoftwareByLicenseType() {
        service.saveSoftware(software);
        List<Software> byLicense = service.getSoftwareByLicenseType("Commercial");
        assertFalse(byLicense.isEmpty());
        System.out.println("By License: " + byLicense);
    }

    @Test
    @Order(7)
    void searchSoftwareByName() {
        service.saveSoftware(software);
        List<Software> searchResults = service.searchSoftwareByName("IntelliJ");
        assertFalse(searchResults.isEmpty());
        System.out.println("Search Results: " + searchResults);
    }

    @Test
    @Order(8)
    void deleteSoftware() {
        service.saveSoftware(software);
        service.deleteSoftware("SW-001");
        Optional<Software> deleted = service.findSoftwareById("SW-001");
        assertTrue(deleted.isEmpty());
        System.out.println("Delete successful - record not found");
    }
}