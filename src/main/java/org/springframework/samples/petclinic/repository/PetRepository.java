package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.samples.petclinic.model.Pet;

@NoRepositoryBean
public interface PetRepository {

    /**
     * Save a <code>Pet</code> to the data store, either inserting or updating it.
     *
     * @param pet the <code>Pet</code> to save
     * @see BaseEntity#isNew
     */
    void save(Pet pet) throws DataAccessException;

}
