package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Lab;
import za.ac.cput.Repository.LabRepository;

import java.util.List;

@Service
public class LabService {
    
    @Autowired
    private LabRepository labRepository;
    
    public Lab create(Lab lab) {
        return labRepository.save(lab);
    }
    
    public Lab read(Long id) {
        return labRepository.findById(id).orElse(null);
    }
    
    public Lab update(Lab lab) {
        return labRepository.save(lab);
    }
    
    public boolean delete(Long id) {
        if (labRepository.existsById(id)) {
            labRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Lab> getAll() {
        return labRepository.findAll();
    }
}
