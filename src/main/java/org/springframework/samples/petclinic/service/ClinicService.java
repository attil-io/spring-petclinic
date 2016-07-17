package org.springframework.samples.petclinic.service;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Pet;


public interface ClinicService {

    void savePet(Pet pet) throws DataAccessException;

}
