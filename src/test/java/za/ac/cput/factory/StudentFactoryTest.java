package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Student;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentFactoryTest {
    @Test
        void createStudent() {
            Student student = StudentFactory.createStudent(
                    "Sandile", "Sibiya", "230975623@mycput.ac.za",
                    "Mth040114", "IT", "2023", "3rd Year");
            assertNotNull(student);
            System.out.println(student);
        }
    }