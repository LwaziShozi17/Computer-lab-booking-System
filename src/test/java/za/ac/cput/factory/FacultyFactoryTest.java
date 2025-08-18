package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.Factory.FacultyFactory;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {

    @Test
    void createFaculty() {
        Faculty faculty = FacultyFactory.createFaculty("F001", "Computer Science");
        
        assertNotNull(faculty);
        assertEquals("F001", faculty.getFacultyId());
        assertEquals("Computer Science", faculty.getFacultyName());
    }

    @Test
    void createFacultyWithNullValues() {
        Faculty faculty = FacultyFactory.createFaculty(null, null);
        
        assertNull(faculty);
    }
}
