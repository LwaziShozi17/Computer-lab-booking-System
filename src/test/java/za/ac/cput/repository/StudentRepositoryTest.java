/*   StudentRepositoryTest.java
     StudentRepositoryTest class
     Author: SE Sibiya (230975623)
     Date: 25 May 2025 */

package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    private static Student student = StudentFactory.createStudent(
            "Sandile", "Sibiya", "230975623@mycput.ac.za","Sib040114",
            "230975623", "ICT", "2023", "3 year");

    @Test
    @Order(1)
    void create() {
        Student createdStudent = studentRepository.save(student);
        assertNotNull(createdStudent);
        System.out.println(createdStudent);
    }

    @Test
    @Order(2)
    void read(){
        Student read = studentRepository.findByStudentId(student.getStudentId());
        assertNotNull(read);
        System.out.println(read)
        ;
    }

    @Test
    @Order(3)
    void update() {
        Student update = new Student.Builder().copy(student)
                .setFirstName("Sandile Enough")
                .build();
        Student updatedStudent = studentRepository.save(update);
        assertNotNull(updatedStudent);
        System.out.println(updatedStudent);
    }

    @Test
    @Order(4)
    void delete() {
        studentRepository.deleteByStudentId(student.getStudentId());
        System.out.println("Deleted student : \n" + student.getStudentId());
    }

    @Test
    @Order(5)
    void findAll() {
        for (Student student : studentRepository.getAll()) {
            System.out.println("All Students : \n" + student);
        }

    }

}