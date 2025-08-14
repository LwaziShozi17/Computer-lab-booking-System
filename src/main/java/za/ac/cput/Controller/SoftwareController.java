package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Software;
import za.ac.cput.Service.SoftwareService;

import java.util.List;

@RestController
@RequestMapping("/api/software")
public class SoftwareController {

    private final SoftwareService softwareService;

    @Autowired
    public SoftwareController(SoftwareService softwareService) {
        this.softwareService = softwareService;
    }

    @PostMapping("/create")
    public ResponseEntity<Software> create(@RequestBody Software software) {
        try {
            Software createdSoftware = softwareService.create(software);
            return new ResponseEntity<>(createdSoftware, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Software> read(@PathVariable String id) {
        Software software = softwareService.read(id);
        if (software != null) {
            return new ResponseEntity<>(software, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Software> update(@RequestBody Software software) {
        try {
            Software updatedSoftware = softwareService.update(software);
            if (updatedSoftware != null) {
                return new ResponseEntity<>(updatedSoftware, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = softwareService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Software>> getAll() {
        List<Software> softwareList = softwareService.getAll();
        return new ResponseEntity<>(softwareList, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Software>> findByName(@PathVariable String name) {
        List<Software> softwareList = softwareService.findByName(name);
        return new ResponseEntity<>(softwareList, HttpStatus.OK);
    }

    @GetMapping("/findByVersion/{version}")
    public ResponseEntity<List<Software>> findByVersion(@PathVariable String version) {
        List<Software> softwareList = softwareService.findByVersion(version);
        return new ResponseEntity<>(softwareList, HttpStatus.OK);
    }
}
