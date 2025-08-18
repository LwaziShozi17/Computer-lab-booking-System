package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Lab;
import za.ac.cput.Factory.LabFactory;

import static org.junit.jupiter.api.Assertions.*;

class LabFactoryTest {

    @Test
    void createLab() {
        Lab lab = LabFactory.createLab(1L, "Building A, Room 101", 30, "08:00", "17:00");
        
        assertNotNull(lab);
        assertEquals(1L, lab.getLabId());
        assertEquals("Building A, Room 101", lab.getLocation());
        assertEquals(30, lab.getCapacity());
        assertEquals("08:00", lab.getOpeningHours());
        assertEquals("17:00", lab.getClosingHours());
    }

    @Test
    void createLabWithInvalidCapacity() {
        Lab lab = LabFactory.createLab(1L, "Building A", 0, "08:00", "17:00");
        
        assertNull(lab);
    }

    @Test
    void createLabWithNullValues() {
        Lab lab = LabFactory.createLab(null, null, 0, null, null);
        
        assertNull(lab);
    }
}
