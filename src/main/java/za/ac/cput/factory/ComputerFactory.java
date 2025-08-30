package za.ac.cput.factory;

import za.ac.cput.domain.Computer;

public class ComputerFactory {
    public static Computer createComputer(String computerId, String labId, String faculty, String status, String software) {

        return new Computer.Builder()
                .setComputerId(computerId)
                .setLabId(labId)
                .setFaculty(faculty)
                .setStatus(status)
                .setSoftware(software)
                .build();
    }
}
