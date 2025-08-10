package za.ac.cput;

import za.ac.cput.Domain.Computer;
import za.ac.cput.Domain.Report;
import za.ac.cput.factory.ComputerFactory; // Assuming you have a ComputerFactory
import za.ac.cput.factory.ReportFactory; // Assuming you have a ReportFactory
import za.ac.cput.Repository.ComputerRepository;
import za.ac.cput.Repository.ReportRepository;

public class Main {
    public static void main(String[] args) {

        // Create a new Computer
        Computer computer = ComputerFactory.createComputer("C1", "Lab1", "Engineering", "Empty", "Java");
        ComputerRepository.getRepository().create(computer);
        System.out.println("Computer Created: " + computer);


        // Create a new Report
        Report report = ReportFactory.createReport("Usage", "Admin1", computer.getComputerId());
        ReportRepository.getRepository().create(report);
        System.out.println("Report Created: " + report);
    }
}