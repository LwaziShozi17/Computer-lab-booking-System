package za.ac.cput.util;

import za.ac.cput.Domain.Computer;
import za.ac.cput.factory.ComputerFactory;


public class Helper {

    public static Computer createDefaultComputer() {
        return ComputerFactory.createComputer("C1", "L1", "Engineering", "Occupied", "Windows");
    }

    public static Computer createEmptyComputer() {
        return ComputerFactory.createComputer("C2", "L2", "Science", "Empty", "Linux");
    }

    public static Computer createCustomComputer(String computerId, String labId, String faculty, String status, String software) {
        return ComputerFactory.createComputer(computerId, labId, faculty, status, software);
    }
}
