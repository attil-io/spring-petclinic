package org.springframework.samples.petclinic.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.service.ClinicService;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class VetSpecialtyFormatterTests {

    @Mock
    private ClinicService clinicService;

    private VetSpecialtyFormatter vetSpecialtyFormatter;

    @Before
    public void setup() {
        vetSpecialtyFormatter = new VetSpecialtyFormatter(clinicService);
    }

    @Test
    public void testPrintEmpty() {
        Specialty specialty = null;
        String specialtyName = vetSpecialtyFormatter.print(specialty, Locale.ENGLISH);
        assertEquals("<EMPTY>", specialtyName);
    }


    @Test
    public void testPrint() {
        Specialty specialty = new Specialty();
        specialty.setName("anesthetist");
        String specialtyName = vetSpecialtyFormatter.print(specialty, Locale.ENGLISH);
        assertEquals("anesthetist", specialtyName);
    }
    
    @Test
    public void testPrintAnother() {
        Specialty specialty = new Specialty();
        specialty.setName("surgeon");
        String specialtyName = vetSpecialtyFormatter.print(specialty, Locale.ENGLISH);
        assertEquals("surgeon", specialtyName);
    }

    @Test
    public void shouldParse() throws ParseException {
        Mockito.when(clinicService.findVetSpecialties()).thenReturn(makeVetSpecialties());
        Specialty specialty = vetSpecialtyFormatter.parse("dentist", Locale.ENGLISH);
        assertEquals("dentist", specialty.getName());
    }


    @Test(expected = ParseException.class)
    public void shouldThrowParseException() throws ParseException {
        Mockito.when(clinicService.findVetSpecialties()).thenReturn(makeVetSpecialties());
        vetSpecialtyFormatter.parse("surgeon", Locale.ENGLISH);
    }

    private Collection<Specialty> makeVetSpecialties() {
        Collection<Specialty> specialties = new ArrayList<>();
        specialties.add(new Specialty(){
            {
                setName("dentist");
            }
        });
        return specialties;
    }

}
