package za.ac.cput.service;

import za.ac.cput.Domain.Computer;
import za.ac.cput.Repository.ComputerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerService {
    private static ComputerService service = null;
    private final ComputerRepository repository;

    private ComputerService() {
        repository = ComputerRepository.getRepository();
    }

    public static ComputerService getService() {
        if (service == null) {
            service = new ComputerService();
        }
        return service;
    }

    // CREATE
    public Computer create(Computer computer) {
        return repository.create(computer);
    }

    // READ
    public Computer read(String computerId) {
        return repository.read(computerId);
    }

    // UPDATE
    public void update(Computer computer) {
        repository.update(computer);
    }

    // DELETE
    public void delete(String computerId) {
        repository.delete(computerId);
    }

    // GET ALL
    public List<Computer> getAll() {
        return new ArrayList<>(repository.getAll().values());
    }

    // BUSINESS LOGIC METHODS
    public List<Computer> getAvailableComputers() {
        return repository.findByStatus("Empty");
    }

    public List<Computer> getComputersByLab(String labId) {
        return repository.findByLabId(labId);
    }

    public List<Computer> getComputersByFaculty(String faculty) {
        return repository.getAll().values()
                .stream()
                .filter(computer -> computer.getFaculty().equalsIgnoreCase(faculty))
                .collect(Collectors.toList());
    }

    // VALIDATION
    public boolean isValidComputer(Computer computer) {
        return computer != null &&
                computer.getComputerId() != null &&
                computer.getLabId() != null &&
                computer.getStatus() != null;
    }
}