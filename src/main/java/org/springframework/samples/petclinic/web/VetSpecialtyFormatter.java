package org.springframework.samples.petclinic.web;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.service.ClinicService;

public class VetSpecialtyFormatter implements Formatter<Specialty> {

    private ClinicService clinicService;
    
    @Autowired
    public VetSpecialtyFormatter(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @Override
    public String print(Specialty specialty, Locale locale) {
        if (null == specialty) {
            return "<EMPTY>";
        }
        return specialty.getName();
    }

    @Override
    public Specialty parse(String text, Locale locale) throws ParseException {
        Collection<Specialty> findVetSpecialties = this.clinicService.findVetSpecialties();
        for (Specialty specialty : findVetSpecialties) {
            if (specialty.getName().equals(text)) {
                return specialty;
            }
        }
        throw new ParseException("specialty not found: " + text, 0);
    }

}
