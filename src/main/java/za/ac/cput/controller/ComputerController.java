package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Computer;
import za.ac.cput.service.ComputerService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/http/cputlibrary.com")
public class ComputerController {
    private final ComputerService computerService;

    @Autowired
    private ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    // Method to search and get all computer by Faculty
    @GetMapping("/SearchComputer/{faculty}")
    public ResponseEntity<?> searchComputersByFaculty(@PathVariable String faculty) {
        try {
            List<Computer> computer = computerService.searchByFaculty(faculty);

            if (computer.isEmpty()) {
                return  ResponseEntity.badRequest().body("Computer not found");
            }

            return ResponseEntity.ok(computer);

        } catch (RuntimeException e) {
            throw new RuntimeException("Computer not found for faculty : " + faculty);
        //    return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }



}
