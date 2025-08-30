package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Computer;

import static org.junit.jupiter.api.Assertions.*;

class ComputerFactoryTest {

    @Test
    void createComputer() {
        Computer computer = ComputerFactory.createComputer(
                "C-101",
                "Lab-5",
                "Engineering",
                "Operational",
                "Windows 10, MS Office"
        );

        assertNotNull(computer);
        System.out.println(computer);


    }
}