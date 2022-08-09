package mx.com.anerware.workshop.postgresql.videogamestore.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VideoGameUnitTR {
	private Integer videoGameIdx;
	private String title;
	private String description;
	private String developedBy;
	private Integer year;
	private Integer players;
}
