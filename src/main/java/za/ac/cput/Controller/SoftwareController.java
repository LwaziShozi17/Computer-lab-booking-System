package za.ac.cput.Controller;

import za.ac.cput.Domain.Software;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* Sithandiwe Ntombela 221805265 */


public class SoftwareController {
    private final List<Software> softwareList;

    public SoftwareController() {
        this.softwareList = new ArrayList<>();
    }

    // Create a new Software entry
    public void addSoftware(Software software) {
        softwareList.add(software);
    }

    // Read all Software entries
    public List<Software> getAllSoftware() {
        return new ArrayList<>(softwareList);
    }

    // Find a Software entry by ID
    public Optional<Software> getSoftwareById(String softwareId) {
        return softwareList.stream()
                .filter(software -> software.getSoftwareId().equals(softwareId))
                .findFirst();
    }

    // Update a Software entry
    public void updateSoftware(String softwareId, Software updatedSoftware) {
        Optional<Software> existingSoftware = getSoftwareById(softwareId);
        existingSoftware.ifPresent(software -> {
            softwareList.remove(software);
            softwareList.add(updatedSoftware);
        });
    }

    // Delete a Software entry
    public void deleteSoftware(String softwareId) {
        softwareList.removeIf(software -> software.getSoftwareId().equals(softwareId));
    }
}