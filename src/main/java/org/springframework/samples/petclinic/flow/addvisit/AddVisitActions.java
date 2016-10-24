package org.springframework.samples.petclinic.flow.addvisit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    
    public Collection<Pet> findPetsForOwner(Owner owner) {
        return cs.findPetsByOwnerId(owner.getId());
    }
    
    public Date convertToDate(String dateStr) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        return parser.parse(dateStr);
    }
    
    public Pet fetchPetById(int petId) {
        return cs.findPetById(petId);
    }
    
    @Transactional
    public void saveVisit(AddVisit addVisit) {
        Visit visit = new Visit();
        Pet pet = addVisit.getChosenPet();
        pet.addVisit(visit);
        LocalDate ld = new LocalDate(addVisit.getVisitDate());
        visit.setDate(ld);
        visit.setDescription("added by visit flow");
        cs.saveVisit(visit);
        cs.savePet(pet);
    }
}
