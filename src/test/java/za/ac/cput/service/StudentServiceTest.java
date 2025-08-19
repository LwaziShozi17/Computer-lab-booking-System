package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentServiceTest {
    @Autowired
    private IStudent studentService;

    private Student student = StudentFactory.createStudent(
            "Lwazi", "Shozi", "220975623@mycput.ac.za", "Sib040", Long.valueOf("220975623"), "ICT : AppDev", "2024", "Third Year");

    @Test
    @Order(1)
    void create() {
        Student savedStudent = studentService.create(student);
        assertNotNull(savedStudent);
        System.out.println("Saved Student: " + savedStudent);
    }

    @Test
    @Order(2)
    void read() {
        Student readStudent = studentService.read(student.getStudentId());
        assertNotNull(readStudent);
        System.out.println("Read Student: " + readStudent);
    }
    @Test
    @Order(3)
    void update() {
        Student updatedStudent = new Student.Builder().copy(student)
                .setLastName("Mthunzi")
                .setFaculty("Entrepreneurship and Business")
                .build();
        Student result = studentService.update(updatedStudent);
        assertNotNull(result);
        System.out.println("Updated Student: " + result);
    }
//    @Test
//    @Order(4)
//    void delete() {
//        Student deletedStudent = studentService.delete(student.getStudentId());
//        assertNotNull(deletedStudent);
//        assertEquals(student.getStudentId(), deletedStudent.getStudentId());
//        System.out.println("Deleted Student: " + deletedStudent);
//    }
    @Test
    @Order(5)
    void findAllStudent() {
        for (Student student : studentService.findAllStudent()) {
            assertNotNull(student);
            System.out.println("Found Student: " + student);
        }
    }
}