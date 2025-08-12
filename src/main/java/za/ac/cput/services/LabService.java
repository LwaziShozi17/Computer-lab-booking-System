package za.ac.cput.services;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Lab;
import za.ac.cput.util.Helper;

import java.util.*;

public class LabService {
    private final Map<Long, Lab> labStore = new HashMap<>();

    public Lab create(Lab lab){
        Long id = lab.getLabId() == null ? Helper.generateId() : lab.getLabId();
        Lab built = new Lab().new Builder().copy(lab).setLabId(id).build();
        labStore.put(id, built);
        return built;
    }

    public Optional<Lab> read(Long id){
        return Optional.ofNullable(labStore.get(id));
    }

    public Lab update(Lab lab){
        if(lab.getLabId() == null || !labStore.containsKey(lab.getLabId())){
            throw new NoSuchElementException("Lab does not exist");
        }
        labStore.put(lab.getLabId(), lab);
        return lab;
    }

    public void delete(Long id){
        labStore.remove(id);
    }

    public List<Lab> findAll(){
        return new ArrayList<>(labStore.values());
    }
}
