package za.ac.cput.factory;

import za.ac.cput.Domain.Lab;

//Thuso Siduka 220041776
public class LabFactory {
    public static Lab createLab(Long id, String location, int capacity, String openingHours, String closingHours){
        if(location == null || location.trim().isEmpty()){
            throw new IllegalArgumentException("Location is required");
        }
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        return new Lab.Builder()
                .setLabId(id)
                .setLocation(location)
                .setCapacity(capacity)
                .setOpeningHours(openingHours)
                .setClosingHours(closingHours)
                .build();
    }
}
