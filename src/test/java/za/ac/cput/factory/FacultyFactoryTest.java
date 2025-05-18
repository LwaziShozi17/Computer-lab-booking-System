package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Faculty;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {

    @Test
    @Order(1)
    void testCreateFaculty() {
        Faculty faculty = FacultyFactory.createFaculty("Informatics and Design");
        System.out.println(faculty);
        assertNotNull(faculty);
    }

    @Test
    @Order(2)
    void testCreateFacultyWithId(){
        Faculty faculty= FacultyFactory.createFacultyWithId("FAC-IND-1234", "Informatics and Design");
        System.out.println(faculty);
        assertEquals("FAC-IND-1234", faculty.getFacultyId());
    }

    @Test
    @Order(3)
    void testCreateFacultyWithInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FacultyFactory
                .createFaculty(("")));
        assertEquals("Invalid faculty name", exception.getMessage());
    }

    @Test
    @Order(4)
    void testCreateFacultyWithInvalidIdFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FacultyFactory
                .createFacultyWithId("12345", "Invalid ID Format"));
        assertEquals("Invalid faculty ID format", exception.getMessage());
    }

}
