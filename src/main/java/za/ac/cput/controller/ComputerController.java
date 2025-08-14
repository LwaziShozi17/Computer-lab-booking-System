package za.ac.cput.controller;

import za.ac.cput.Domain.Computer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ComputerController {
    private final List<Computer> computers;

    public ComputerController() {
        this.computers = new ArrayList<>();
    }

    // Create a new Computer
    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    // Read all Computers
    public List<Computer> getAllComputers() {
        return new ArrayList<>(computers);
    }

    // Find a Computer by ID
    public Optional<Computer> getComputerById(String computerId) {
        return computers.stream()
                .filter(computer -> computer.getComputerId().equals(computerId))
                .findFirst();
    }

    // Update a Computer
    public void updateComputer(String computerId, Computer updatedComputer) {
        Optional<Computer> existingComputer = getComputerById(computerId);
        existingComputer.ifPresent(computer -> {
            computers.remove(computer);
            computers.add(updatedComputer);
        });
    }

    // Delete a Computer
    public void deleteComputer(String computerId) {
        computers.removeIf(computer -> computer.getComputerId().equals(computerId));
    }
}