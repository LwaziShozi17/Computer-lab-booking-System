package za.ac.cput.Service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Software;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareServiceImplTest {

    private SoftwareServiceImpl softwareService;
    private Software software1;
    private Software software2;

    @BeforeEach
    void setUp() {
        softwareService = new SoftwareServiceImpl();
        
        software1 = new Software.Builder()
                .setName("Visual Studio Code")
                .setVersion("1.85.0")
                .setLicenseType("MIT")
                .build();
        
        software2 = new Software.Builder()
                .setName("IntelliJ IDEA")
                .setVersion("2023.3")
                .setLicenseType("Commercial")
                .build();
    }

    @Test
    void create() {
        Software created = softwareService.create(software1);
        assertNotNull(created);
        assertNotNull(created.getSoftwareId());
        assertEquals("Visual Studio Code", created.getName());
    }

    @Test
    void createNullSoftware() {
        assertThrows(IllegalArgumentException.class, () -> softwareService.create(null));
    }

    @Test
    void read() {
        Software created = softwareService.create(software1);
        Software found = softwareService.read(created.getSoftwareId());
        assertNotNull(found);
        assertEquals(created.getSoftwareId(), found.getSoftwareId());
    }

    @Test
    void readNonExistent() {
        Software found = softwareService.read("non-existent-id");
        assertNull(found);
    }

    @Test
    void update() {
        Software created = softwareService.create(software1);
        Software updated = new Software.Builder()
                .copy(created)
                .setVersion("1.86.0")
                .build();
        
        Software result = softwareService.update(updated);
        assertNotNull(result);
        assertEquals("1.86.0", result.getVersion());
    }

    @Test
    void updateNonExistent() {
        Software nonExistent = new Software.Builder()
                .setSoftwareId("non-existent-id")
                .setName("Test")
                .build();
        
        assertThrows(IllegalArgumentException.class, () -> softwareService.update(nonExistent));
    }

    @Test
    void delete() {
        Software created = softwareService.create(software1);
        boolean deleted = softwareService.delete(created.getSoftwareId());
        assertTrue(deleted);
        assertNull(softwareService.read(created.getSoftwareId()));
    }

    @Test
    void deleteNonExistent() {
        boolean deleted = softwareService.delete("non-existent-id");
        assertFalse(deleted);
    }

    @Test
    void getAll() {
        softwareService.create(software1);
        softwareService.create(software2);
        
        List<Software> allSoftware = softwareService.getAll();
        assertEquals(2, allSoftware.size());
    }

    @Test
    void findByName() {
        softwareService.create(software1);
        softwareService.create(software2);
        
        List<Software> found = softwareService.findByName("Visual");
        assertEquals(1, found.size());
        assertEquals("Visual Studio Code", found.get(0).getName());
    }

    @Test
    void findByVersion() {
        softwareService.create(software1);
        softwareService.create(software2);
        
        List<Software> found = softwareService.findByVersion("1.85.0");
        assertEquals(1, found.size());
        assertEquals("1.85.0", found.get(0).getVersion());
    }

    @Test
    void findByNameEmpty() {
        List<Software> found = softwareService.findByName("");
        assertTrue(found.isEmpty());
    }

    @Test
    void findByVersionEmpty() {
        List<Software> found = softwareService.findByVersion("");
        assertTrue(found.isEmpty());
    }
}
