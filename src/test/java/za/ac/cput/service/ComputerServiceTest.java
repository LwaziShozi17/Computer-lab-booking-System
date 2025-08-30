package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Computer;
import za.ac.cput.factory.ComputerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ComputerServiceTest {
    @Autowired
    private IComputer computerService;

    private Computer computer = ComputerFactory.createComputer(
            "C-119",
            "Lab-10",
            "Information",
            "Available",
            "Cisco Packet tracer"
    );

    @Test
    @Order(1)
    void create() {
        Computer savedComputer = computerService.create(computer);
        assertNotNull(savedComputer);
        System.out.println("Created Computer: \n" + savedComputer);
    }

    @Test
    @Order(2)
    void read() {
        Computer readComputer = computerService.read(computer.getComputerId());
        assertNotNull(readComputer);
        System.out.println("Saved computer ID: " + readComputer);
    }

//    @Test
//    @Order(3)
//    void update() {
//        Computer updatedComputer = new Computer.Builder().copy(computer)
//                .setLabId("Lab-10")
//                .setStatus("Under Maintenance")
//                .build();
//        Computer updateComputer = computerService.update(updatedComputer);
//        assertNotNull(updateComputer);
//        System.out.println("Updated Computer: " + updateComputer);
//    }

    @Test
    @Order(4)
    void delete() {
        Computer deletedComputer = computerService.delete(computer.getComputerId());
        assertNotNull(deletedComputer);
        System.out.println("Deleted computer ID: " + deletedComputer.getComputerId());
    }


    @Test
    @Order(5)
    void getAllComputer() {
        for (Computer comp : computerService.getAllComputer()) {
            System.out.println(comp);
        }
    }

    @Test
    @Order(6)
    void searchByFaculty() {
        String faculty = "Engineering";

        for (Computer compt : computerService.searchByFaculty(faculty)) {
        System.out.println("Found Computer by Faculty: " + compt);

        }
    }
}


//package za.ac.cput.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.annotation.Order;
//import org.springframework.transaction.annotation.Transactional;
//import za.ac.cput.domain.Computer;
//import za.ac.cput.factory.ComputerFactory;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Transactional // CRITICAL: This ensures each test runs in its own transaction
//class ComputerServiceTest {
//
//    @Autowired
//    private IComputer computerService;
//
//    private Computer computer;
//    private String computerId;
//
//    @BeforeEach
//    void setUp() {
//        // Create a NEW computer instance before each test
//        computer = ComputerFactory.createComputer(
//                "C-" + System.currentTimeMillis(), // Unique ID for each test
//                "Lab-10",
//                "Engineering",
//                "Available",
//                "Eng draw."
//        );
//    }
//
//    @Test
//    @Order(1)
//    void create() {
//        Computer savedComputer = computerService.create(computer);
//        assertNotNull(savedComputer);
//        computerId = savedComputer.getComputerId(); // Store the ID for later tests
//        System.out.println("Created Computer: \n" + savedComputer);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        // First create a computer, then read it
//        Computer savedComputer = computerService.create(computer);
//        Computer readComputer = computerService.read(savedComputer.getComputerId());
//        assertNotNull(readComputer);
//        assertEquals(savedComputer.getComputerId(), readComputer.getComputerId());
//        System.out.println("Read computer: " + readComputer);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        // First create a computer
//        Computer savedComputer = computerService.create(computer);
//
//        Computer updatedComputer = new Computer.Builder().copy(savedComputer)
//                .setLabId("Lab-10-UPDATED")
//                .setStatus("Under Maintenance")
//                .build();
//
//        Computer result = computerService.update(updatedComputer);
//        assertNotNull(result);
//        assertEquals("Under Maintenance", result.getStatus());
//        assertEquals("Lab-10-UPDATED", result.getLabId());
//        System.out.println("Updated Computer: " + result);
//    }
//
//    @Test
//    @Order(4)
//    void delete() {
//        // First create a computer, then delete it
//        Computer savedComputer = computerService.create(computer);
//        Computer deletedComputer = computerService.delete(savedComputer.getComputerId());
//        assertNotNull(deletedComputer);
//        assertEquals(savedComputer.getComputerId(), deletedComputer.getComputerId());
//        System.out.println("Deleted computer ID: " + deletedComputer.getComputerId());
//    }
//
//    @Test
//    @Order(5)
//    void getAllComputer() {
//        // Create at least one computer first
//        computerService.create(computer);
//
//        List<Computer> allComputers = computerService.getAllComputer();
//        assertNotNull(allComputers);
//        assertFalse(allComputers.isEmpty());
//
//        for (Computer comp : allComputers) {
//            System.out.println(comp);
//        }
//    }
//
//    @Test
//    @Order(6)
//    void searchByFaculty() {
//        // First create the computer
//        Computer savedComputer = computerService.create(computer);
//
//        String faculty = "Engineering";
//        List<Computer> computers = computerService.searchByFaculty(faculty);
//
//        assertNotNull(computers);
//        assertFalse(computers.isEmpty());
//
//        for (Computer compt : computers) {
//            System.out.println("Found Computer by Faculty: " + compt);
//            assertEquals("Engineering", compt.getFaculty());
//        }
//    }
//}


