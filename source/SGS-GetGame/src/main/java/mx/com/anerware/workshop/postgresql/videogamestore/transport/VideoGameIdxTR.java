package mx.com.anerware.workshop.postgresql.videogamestore.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VideoGameIdxTR{
	private Integer videoGameIdx;
}
