package mx.com.anerware.workshop.postgresql.videogamestore.restobj;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class VideoGameGeneralData implements Serializable{

	private static final long serialVersionUID = -7302658954429316322L;
	
	@Schema(description = "Response Code 00 is success", 
            example = "00", required = true)
    @NotBlank
    @Size(max = 50)
	private String code;
	
	@Schema(description = "Description of response code", 
            example = "Successful Process", required = true)
    @NotBlank
    @Size(max = 50)
	private String description;
	
	@Schema(description = "Extra Information about the process", 
            example = "1 row inserted", required = true)
    @NotBlank
    @Size(max = 50)
	private String extraInfo;
}
