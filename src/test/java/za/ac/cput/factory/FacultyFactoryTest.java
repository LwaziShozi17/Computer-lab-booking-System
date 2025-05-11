package za.ac.cput.factory;
/*Booking.java
FacultyFactoryTest class
Author: SM Thwabuse(220246009)
Date: 18 May 2025*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {

    private static Faculty f1 = FacultyFactory.createFaculty("FAC-Eng", "Engineering Faculty");

    private static Faculty f2 = FacultyFactory.createFacultyWithGeneratedId("Informatics and Design");

    private static Faculty f3 = FacultyFactory.createFaculty(null, "Faculty Not Found");

    private static Faculty f4 = FacultyFactory.createFacultyWithGeneratedId("    ");

    @Test
    @Order(1)
    public void testCreateFaculty() {
        assertNotNull(f1);
        assertEquals("FAC-Eng", f1.getFacultyId());
        assertEquals("Engineering Faculty", f1.getFacultyName());
        System.out.println("Faculty created:" + f1);
    }

    @Test
    @Order(2)
    public void testCreateFacultyWithGeneratedId() {
        assertNotNull(f2);
        assertTrue(Helper.isValidFacultyId(f2.getFacultyId()));
        assertEquals("Informatics and Design", f2.getFacultyName());
        System.out.println("Generated ID Faculty: " + f2);
    }

    @Test
    @Order(3)
    public void testCreateFacultyWithNullId() {
        assertNull(f3);
        System.out.println("Null Faculty Test Passed - as expected");
    }

    @Test
    @Order(4)
    public void testCreateFacultyWithEmptyName() {
        assertNull(f4);
        System.out.println("Empty Faculty Name Test Passed");
    }

    @Test
    @Disabled
    @Order(5)
    public void testNotImplementedYet() {
    }
}
