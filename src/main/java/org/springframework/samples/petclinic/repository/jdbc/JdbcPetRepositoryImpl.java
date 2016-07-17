package org.springframework.samples.petclinic.repository.jdbc;

import java.security.acl.Owner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPetRepositoryImpl implements PetRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertPet;

    @Autowired
    public JdbcPetRepositoryImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        this.insertPet = new SimpleJdbcInsert(dataSource)
            .withTableName("pets")
            .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Pet pet) throws DataAccessException {
        if (pet.isNew()) {
            Number newKey = this.insertPet.executeAndReturnKey(
                createPetParameterSource(pet));
            pet.setId(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                "UPDATE pets SET name=:name, " +
                    " WHERE id=:id",
                createPetParameterSource(pet));
        }
    }

    /**
     * Creates a {@link MapSqlParameterSource} based on data values from the supplied {@link Pet} instance.
     */
    private MapSqlParameterSource createPetParameterSource(Pet pet) {
        return new MapSqlParameterSource()
            .addValue("id", pet.getId())
            .addValue("name", pet.getName())
;
    }

}
