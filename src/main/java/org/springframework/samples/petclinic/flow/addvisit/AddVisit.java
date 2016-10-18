package org.springframework.samples.petclinic.flow.addvisit;

import java.io.Serializable;

import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Vet;

public class AddVisit implements Serializable {
    private Vet vet;
    private Owner owner;
    
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
}
