package org.springframework.samples.petclinic.flow.addvisit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Component;

@Component
public class AddVisitActions {

    @Autowired
    private ClinicService cs;
    
    public void setVetById(AddVisit addVisit, int vetId) {
        Collection<Vet> vets = cs.findVets();
        Vet vet = null;
        for (Vet v: vets) {
            if (v.getId() == vetId) {
                vet = v;
                break;
            }
        }
        addVisit.setVet(vet);
    }
    
    public Owner lookupOwner(String lastName,  String firstName) throws OwnerNotFoundException {
        Collection<Owner> owners = cs.findOwnerByLastName(lastName);
        if (owners.isEmpty()) {
            throw new OwnerNotFoundException();
        }
        return owners.stream().findFirst().get();
    }
}