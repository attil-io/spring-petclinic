package org.springframework.samples.petclinic.flow.addvisit;

import java.io.Serializable;

import org.springframework.samples.petclinic.model.Vet;

public class AddVisit implements Serializable {
    private Vet vet;

    public void setVet(Vet vet) {
        this.vet = vet;
    }
    
    public Vet getVet() {
        return vet;
    }
}
