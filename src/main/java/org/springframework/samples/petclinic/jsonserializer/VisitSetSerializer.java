package org.springframework.samples.petclinic.jsonserializer;

import java.io.IOException;
import java.util.Collection;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.samples.petclinic.model.Visit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class VisitSetSerializer extends JsonSerializer<Collection<Visit>> {

	private DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd-MM-yyyy");
	
	@Override
	public void serialize(Collection<Visit> visits, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		gen.writeStartArray();
		for (Visit visit: visits) {
			gen.writeStartObject();
			gen.writeNumberField("id", visit.getId());
			gen.writeStringField("description", visit.getDescription());
			gen.writeStringField("date", dtfOut.print(visit.getDate()));
			gen.writeEndObject();
		}
		gen.writeEndArray();
	}

}
