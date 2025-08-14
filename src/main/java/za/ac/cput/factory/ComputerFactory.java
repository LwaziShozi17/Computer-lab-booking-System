package za.ac.cput.factory;

import za.ac.cput.Domain.Computer;


public class ComputerFactory {
    public static Computer createComputer(String computerId, String labId,
                                          String faculty, String status,
                                          String software) {
        return new Computer.Builder()
                .setComputerId(computerId)
                .setLabId(labId)
                .setFaculty(faculty)
                .setStatus(status)
                .setSoftware(software)
                .build();
    }

    public static Computer createComputer(String labId, String faculty,
                                          String software) {
        String generatedId = generateComputerId();
        return createComputer(generatedId, labId, faculty, "Empty", software);
    }

    private static String generateComputerId() {
        return "COMP-" + System.currentTimeMillis();
    }
}