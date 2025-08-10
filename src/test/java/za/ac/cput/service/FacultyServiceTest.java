package za.ac.cput.service;

/*
 FacultyServiceTest class
 Author: SM Thwabuse (220246009)
 Date: 12/08/2025
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.factory.FacultyFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FacultyServiceTest {
    @Autowired
    private FacultyService facultyService;

    private Faculty faculty = FacultyFactory.createFaculty("Informatics and Design");

    @Test
    @Order(1)
    void create() {
        Faculty savedFaculty = facultyService.save(faculty);
        assertNotNull(savedFaculty);
        System.out.println("Saved Faculty: " + savedFaculty);
    }

    @Test
    @Order(2)
    void read() {
        Faculty readFaculty = facultyService.read(faculty.getFacultyId());
        assertNotNull(readFaculty);
        System.out.println("Read Faculty: " + readFaculty);
    }

    @Test
    @Order(3)
    void update() {
        Faculty updatedFaculty = new Faculty.Builder().copy(faculty)
                .setFacultyName("Informatics, Design and Innovation")
                .build();
        Faculty result = facultyService.update(updatedFaculty);
        assertNotNull(result);
        System.out.println("Updated Faculty: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = facultyService.delete(faculty.getFacultyId());
        assertTrue(success);
        System.out.println("Deleted Faculty ID: " + faculty.getFacultyId());
    }

    @Test
    @Order(5)
    void getAll() {
        for (Faculty faculty : facultyService.getAll().values()) {
            assertNotNull(faculty);
            System.out.println("Found Faculty: " + faculty);
        }
    }
}