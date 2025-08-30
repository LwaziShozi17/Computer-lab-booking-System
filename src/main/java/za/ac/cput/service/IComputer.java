package za.ac.cput.service;

import za.ac.cput.domain.Computer;

import java.util.List;

public interface IComputer extends IService<Computer, String> {

    List<Computer> getAllComputer();
    List<Computer> searchByFaculty(String faculty);
}
