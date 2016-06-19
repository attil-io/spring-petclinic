package org.springframework.samples.petclinic.jsonserializer;

import java.io.IOException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.samples.petclinic.model.Pet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PetSerializer extends JsonSerializer<Pet> {

	private DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd-MM-yyyy");
	
	@Override
	public void serialize(Pet pet, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		gen.writeNumberField("id", pet.getId());
		gen.writeStringField("name", pet.getName());
		gen.writeStringField("type", pet.getType().toString());
		gen.writeStringField("birthDate", dtfOut.print(pet.getBirthDate()));
		gen.writeEndObject();
	}

}
