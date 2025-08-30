package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Computer;
import za.ac.cput.repository.ComputerRepository;

import java.util.List;

@Service
public class ComputerService implements IComputer {
    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public Computer create(Computer computer) {
        Computer created = computerRepository.findByComputerId(computer.getComputerId());
        if (created != null) {
            throw new RuntimeException("Computer already exists");
        }
        System.out.println("Created computer: " + computer.getComputerId());
        return computerRepository.save(computer);
    }

    @Override
    public Computer read(String s) {
        Computer readComputer = computerRepository.findByComputerId(s);
        if (readComputer == null) {
            throw new RuntimeException("Computer not found");
        }
        System.out.println("Computer found: " + readComputer.getComputerId());
        return readComputer;
    }

    @Override
    public Computer update(Computer computer) {
        Computer updatingComputer = computerRepository.findByComputerId(computer.getComputerId());
        if (updatingComputer == null) {
            throw new RuntimeException("Computer not found");
        }
        System.out.println("Updated computer: " + computer.getComputerId());
        return computerRepository.save(computer);
    }

    @Override
    public Computer delete(String s) {
        Computer deletingComputer = computerRepository.findByComputerId(s);
        if (deletingComputer == null) {
            throw new RuntimeException("Computer not found");
        }
        computerRepository.deleteById(s);
        System.out.println("Deleted computer: " + s);
        return deletingComputer;
    }

    @Override
    public List<Computer> getAllComputer() {
        return computerRepository.findAll();
    }

    @Override
    public List<Computer> searchByFaculty(String faculty) {
        List<Computer> comp = computerRepository.findByFaculty(faculty);
        if (comp.isEmpty()) {
            throw new RuntimeException("Computer not found in faculty " + faculty);
        }
        return comp;
    }
}