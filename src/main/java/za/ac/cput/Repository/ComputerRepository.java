package za.ac.cput.Repository;

import za.ac.cput.Domain.Computer;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


public class ComputerRepository {
    private static ComputerRepository repository = null;
    private final Map<String, Computer> computerDB;

    private ComputerRepository() {
        computerDB = new HashMap<>();
    }

    public static ComputerRepository getRepository() {
        if (repository == null) {
            repository = new ComputerRepository();
        }
        return repository;
    }

    public Computer create(Computer computer) {
        computerDB.put(computer.getComputerId(), computer);
        return computer;
    }

    public Computer read(String computerId) {
        return computerDB.get(computerId);
    }

    public void update(Computer computer) {
        if (computerDB.containsKey(computer.getComputerId())) {
            computerDB.put(computer.getComputerId(), computer);
        }
    }

    public void delete(String computerId) {
        computerDB.remove(computerId);
    }

    public Map<String, Computer> getAll() {
        return new HashMap<>(computerDB);
    }

    // Additional query methods
    public List<Computer> findByStatus(String status) {
        return computerDB.values().stream()
                .filter(computer -> computer.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public List<Computer> findByLabId(String labId) {
        return computerDB.values().stream()
                .filter(computer -> computer.getLabId().equalsIgnoreCase(labId))
                .collect(Collectors.toList());
    }
}