package za.ac.cput.Factory;

import za.ac.cput.Domain.Lab;
import za.ac.cput.util.Helper;

public class LabFactory {
    public static Lab createLab(Long labId, String location, int capacity, 
                              String openingHours, String closingHours) {
        if (Helper.isNullOrEmpty(String.valueOf(labId)) || 
            Helper.isNullOrEmpty(location) || 
            capacity <= 0 || 
            Helper.isNullOrEmpty(openingHours) || 
            Helper.isNullOrEmpty(closingHours)) {
            return null;
        }
        
        return new Lab.Builder()
                .setLabId(labId)
                .setLocation(location)
                .setCapacity(capacity)
                .setOpeningHours(openingHours)
                .setClosingHours(closingHours)
                .build();
    }
}
