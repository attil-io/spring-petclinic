package org.springframework.samples.petclinic.flow.addvisit;

import java.io.Serializable;

public class AddVisit implements Serializable {
    private int vetId;

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }
    
    
}
