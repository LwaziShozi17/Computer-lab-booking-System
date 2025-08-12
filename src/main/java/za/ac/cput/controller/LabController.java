package za.ac.cput.controller;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Lab;
import za.ac.cput.services.LabService;

import java.util.List;
import java.util.Optional;


public class LabController {
    private final LabService service;

    public LabController(LabService service){
        this.service = service;
    }

    public Lab createLab(Lab lab){
        return service.create(lab);
    }

    public Optional<Lab> getLab(Long id){
        return service.read(id);
    }

    public Lab updateLab(Lab lab){
        return service.update(lab);
    }

    public void deleteLab(Long id){
        service.delete(id);
    }

    public List<Lab> listLabs(){
        return service.findAll();
    }
}
