package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.PetRepository;

public interface SpringDataPetRepository extends PetRepository, Repository<Pet, Integer> {

}
