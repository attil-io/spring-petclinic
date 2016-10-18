package org.springframework.samples.petclinic.flow.addvisit;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Vet;

public class AddVisit implements Serializable {
    private Vet vet;
    private Owner owner;
    private Collection<Pet> pets;
    private Pet chosenPet;
    private Date visitDate;
    
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    
    public Vet getVet() {
        return vet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Collection<Pet> getPets() {
        return pets;
    }

    public void setPets(Collection<Pet> pets) {
        this.pets = pets;
    }

    public Pet getChosenPet() {
        return chosenPet;
    }

    public void setChosenPet(Pet chosenPet) {
        this.chosenPet = chosenPet;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
