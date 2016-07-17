package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractClinicServiceTests {

    @Autowired
    protected ClinicService clinicService;

    @Test
    @Transactional
    public void shouldInsertPetIntoDatabaseAndGenerateId() {
        Pet pet = new Pet();
        pet.setName("bowser");

        this.clinicService.savePet(pet);

        // checks that id has been generated
        assertThat(pet.getId()).isNotNull();
    }

}

