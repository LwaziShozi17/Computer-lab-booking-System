/*
StudentFactoryTest.java
Student FactoryTest  class
Author: SE Sibiya (230975623)
Date: 18 May 2025
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentFactoryTest {
    @Test
        void createStudent() {
            Student student = StudentFactory.createStudent(
                    "Sandile",
                    "Sibiya",
                    "230975623@mycput.ac.za",
                    "Mth040",
                    230975623L,
                    "ICT",
                    "2023",
                    "Third Year");
            assertNotNull(student);
            System.out.println(student);
        }
    }