package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.Repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    
    @Autowired
    private FacultyRepository facultyRepository;
    
    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    
    public Faculty read(String id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    
    public boolean delete(String id) {
        if (facultyRepository.existsById(id)) {
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}
