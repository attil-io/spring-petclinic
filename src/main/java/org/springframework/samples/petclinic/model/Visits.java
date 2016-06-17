package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Visits {
    private List<Visit> visits;

    @XmlElement
    public List<Visit> getVisitList() {
        if (visits == null) {
        	visits = new ArrayList<>();
        }
        return visits;
    }
}
