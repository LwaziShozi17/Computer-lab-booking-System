package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Lab;
import za.ac.cput.Repository.LabRepository;
import za.ac.cput.Service.LabService;

import java.util.List;

@Service
public class LabServiceImpl implements LabService {

    private final LabRepository labRepository;

    @Autowired
    public LabServiceImpl(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    @Override
    public Lab create(Lab lab) {
        return labRepository.save(lab);
    }

    @Override
    public Lab read(Long id) {
        return labRepository.findById(id).orElse(null);
    }

    @Override
    public Lab update(Lab lab) {
        return labRepository.save(lab);
    }

    @Override
    public boolean delete(Long id) {
        if (labRepository.existsById(id)) {
            labRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Lab> getAll() {
        return labRepository.findAll();
    }

    @Override
    public List<Lab> findByLocation(String location) {
        return labRepository.findByLocation(location);
    }

    @Override
    public List<Lab> findByCapacityGreaterThanEqual(int capacity) {
        return labRepository.findByCapacityGreaterThanEqual(capacity);
    }
}
