package za.ac.cput.repository;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Lab;
import java.util.*;

public class LabRepository {
    private static LabRepository repository = null;
    private final Map<Long, Lab> labDB;

    private LabRepository(){
        this.labDB = new HashMap<>();
    }

    public static LabRepository getRepository(){
        if(repository == null){
            repository = new LabRepository();
        }
        return repository;
    }

    public Lab create(Lab lab){
        this.labDB.put(lab.getLabId(), lab);
        return lab;
    }

    public Lab read(Long labId){
        return this.labDB.get(labId);
    }

    public Lab update(Lab lab){
        if(this.labDB.containsKey(lab.getLabId())){
            this.labDB.put(lab.getLabId(), lab);
            return lab;
        }
        return null;
    }

    public boolean delete(Long labId){
        return this.labDB.remove(labId) != null;
    }

    public Set<Lab> getAll(){
        return new HashSet<>(this.labDB.values());
    }
}
