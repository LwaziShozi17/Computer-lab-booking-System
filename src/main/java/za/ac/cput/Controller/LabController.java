package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Lab;
import za.ac.cput.Service.LabService;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class LabController {

    private final LabService labService;

    @Autowired
    public LabController(LabService labService) {
        this.labService = labService;
    }

    @PostMapping("/create")
    public ResponseEntity<Lab> create(@RequestBody Lab lab) {
        Lab createdLab = labService.create(lab);
        return new ResponseEntity<>(createdLab, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Lab> read(@PathVariable Long id) {
        Lab lab = labService.read(id);
        if (lab != null) {
            return new ResponseEntity<>(lab, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Lab> update(@RequestBody Lab lab) {
        Lab updatedLab = labService.update(lab);
        if (updatedLab != null) {
            return new ResponseEntity<>(updatedLab, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = labService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Lab>> getAll() {
        List<Lab> labs = labService.getAll();
        return new ResponseEntity<>(labs, HttpStatus.OK);
    }

    @GetMapping("/findByLocation/{location}")
    public ResponseEntity<List<Lab>> findByLocation(@PathVariable String location) {
        List<Lab> labs = labService.findByLocation(location);
        return new ResponseEntity<>(labs, HttpStatus.OK);
    }

    @GetMapping("/findByCapacity/{capacity}")
    public ResponseEntity<List<Lab>> findByCapacity(@PathVariable int capacity) {
        List<Lab> labs = labService.findByCapacityGreaterThanEqual(capacity);
        return new ResponseEntity<>(labs, HttpStatus.OK);
    }
}
