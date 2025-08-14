package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Software;
import za.ac.cput.Service.SoftwareService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SoftwareServiceImpl implements SoftwareService {

    private final Map<String, Software> softwareDatabase = new HashMap<>();

    @Override
    public Software create(Software software) {
        if (software == null) {
            throw new IllegalArgumentException("Software cannot be null");
        }
        
        String id = UUID.randomUUID().toString();
        Software newSoftware = new Software.Builder()
                .copy(software)
                .setSoftwareId(id)
                .build();
        
        softwareDatabase.put(id, newSoftware);
        return newSoftware;
    }

    @Override
    public Software read(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return softwareDatabase.get(id);
    }

    @Override
    public Software update(Software software) {
        if (software == null || software.getSoftwareId() == null) {
            throw new IllegalArgumentException("Software and ID cannot be null");
        }
        
        if (!softwareDatabase.containsKey(software.getSoftwareId())) {
            throw new IllegalArgumentException("Software with ID " + software.getSoftwareId() + " not found");
        }
        
        softwareDatabase.put(software.getSoftwareId(), software);
        return software;
    }

    @Override
    public boolean delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        
        return softwareDatabase.remove(id) != null;
    }

    @Override
    public List<Software> getAll() {
        return new ArrayList<>(softwareDatabase.values());
    }

    @Override
    public List<Software> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return softwareDatabase.values().stream()
                .filter(software -> software.getName() != null && 
                        software.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Software> findByVersion(String version) {
        if (version == null || version.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return softwareDatabase.values().stream()
                .filter(software -> software.getVersion() != null && 
                        software.getVersion().equalsIgnoreCase(version))
                .collect(Collectors.toList());
    }
}
