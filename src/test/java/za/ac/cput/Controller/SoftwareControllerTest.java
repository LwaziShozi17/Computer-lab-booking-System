package za.ac.cput.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Software;
import za.ac.cput.Service.SoftwareService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SoftwareControllerTest {

    @Mock
    private SoftwareService softwareService;

    @InjectMocks
    private SoftwareController softwareController;

    private Software software1;
    private Software software2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        software1 = new Software.Builder()
                .setSoftwareId("1")
                .setName("Visual Studio Code")
                .setVersion("1.85.0")
                .setLicenseType("MIT")
                .build();
        
        software2 = new Software.Builder()
                .setSoftwareId("2")
                .setName("IntelliJ IDEA")
                .setVersion("2023.3")
                .setLicenseType("Commercial")
                .build();
    }

    @Test
    void create() {
        when(softwareService.create(any(Software.class))).thenReturn(software1);
        
        ResponseEntity<Software> response = softwareController.create(software1);
        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Visual Studio Code", response.getBody().getName());
        verify(softwareService, times(1)).create(software1);
    }

    @Test
    void read() {
        when(softwareService.read("1")).thenReturn(software1);
        
        ResponseEntity<Software> response = softwareController.read("1");
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("1", response.getBody().getSoftwareId());
    }

    @Test
    void readNotFound() {
        when(softwareService.read("999")).thenReturn(null);
        
        ResponseEntity<Software> response = softwareController.read("999");
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void update() {
        when(softwareService.update(any(Software.class))).thenReturn(software1);
        
        ResponseEntity<Software> response = softwareController.update(software1);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        when(softwareService.delete("1")).thenReturn(true);
        
        ResponseEntity<Boolean> response = softwareController.delete("1");
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }

    @Test
    void deleteNotFound() {
        when(softwareService.delete("999")).thenReturn(false);
        
        ResponseEntity<Boolean> response = softwareController.delete("999");
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.getBody());
    }

    @Test
    void getAll() {
        List<Software> softwareList = Arrays.asList(software1, software2);
        when(softwareService.getAll()).thenReturn(softwareList);
        
        ResponseEntity<List<Software>> response = softwareController.getAll();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void findByName() {
        List<Software> softwareList = Arrays.asList(software1);
        when(softwareService.findByName("Visual")).thenReturn(softwareList);
        
        ResponseEntity<List<Software>> response = softwareController.findByName("Visual");
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void findByVersion() {
        List<Software> softwareList = Arrays.asList(software1);
        when(softwareService.findByVersion("1.85.0")).thenReturn(softwareList);
        
        ResponseEntity<List<Software>> response = softwareController.findByVersion("1.85.0");
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }
}
