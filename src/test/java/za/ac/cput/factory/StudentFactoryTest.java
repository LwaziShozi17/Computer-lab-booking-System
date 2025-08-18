package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Student;
import za.ac.cput.Factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void createStudent() {
        Student student = StudentFactory.createStudent(
                "S001", "Computer Science", "2023", "2nd Year",
                "John", "Doe", "john.doe@example.com", "password123"
        );
        
        assertNotNull(student);
        assertEquals("S001", student.getStudentId());
        assertEquals("Computer Science", student.getFaculty());
        assertEquals("2023", student.getEnrollmentYear());
        assertEquals("2nd Year", student.getCurrentYear());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("john.doe@example.com", student.getEmail());
    }

    @Test
    void createStudentWithNullValues() {
        Student student = StudentFactory.createStudent(
                null, null, null, null, null, null, null, null
        );
        
        assertNull(student);
    }
}
