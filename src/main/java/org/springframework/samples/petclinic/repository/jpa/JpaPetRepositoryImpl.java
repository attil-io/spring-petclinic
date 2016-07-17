package org.springframework.samples.petclinic.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPetRepositoryImpl implements PetRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Pet pet) {
        if (pet.getId() == null) {
            this.em.persist(pet);
        } else {
            this.em.merge(pet);
        }
    }

}
