package za.ac.cput;


import za.ac.cput.Domain.Maintenance;
import za.ac.cput.Domain.Software;
import za.ac.cput.Controller.MaintenanceController;
import za.ac.cput.Controller.SoftwareController;
import za.ac.cput.util.Helper;


public class Main {
    public static void main(String[] args) {
        // Initialize controllers
        SoftwareController softwareController = new SoftwareController();
        MaintenanceController maintenanceController = new MaintenanceController();

        // Create and add a Software
        Software software = new Software.Builder()
                .setSoftwareId(Helper.generateId())
                .setName("IntelliJ IDEA")
                .setVersion("2023.2")
                .setLicenseType("Commercial")
                .build();

        if (Helper.isSoftwareValid(software)) {
            softwareController.addSoftware(software);
            System.out.println("Software added: " + software);
        }

        // Create and add a Maintenance record
        Maintenance maintenance = new Maintenance.Builder()
                .setMaintenanceId(Helper.generateId())
                .setSoftwareId(software.getSoftwareId()) // Link to the software
                .setDate("2023-10-25")
                .setDescription("Routine update check")
                .build();

        if (Helper.isMaintenanceValid(maintenance)) {
            maintenanceController.addMaintenance(maintenance);
            System.out.println("Maintenance added: " + maintenance);
        }

        // Fetch and print all records
        System.out.println("\nAll Software:");
        softwareController.getAllSoftware().forEach(System.out::println);

        System.out.println("\nAll Maintenance:");
        maintenanceController.getAllMaintenance().forEach(System.out::println);
    }
}