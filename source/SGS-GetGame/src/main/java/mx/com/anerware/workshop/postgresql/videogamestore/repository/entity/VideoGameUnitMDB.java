package mx.com.anerware.workshop.postgresql.videogamestore.repository.entity;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VideoGameUnitMDB {
	
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	public String title;
	public String description;
	public String developedBy;
	public Integer year;
	public Integer players;
}
