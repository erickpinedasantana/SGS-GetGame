package mx.com.anerware.workshop.postgresql.videogamestore.restobj;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class VideoGameUnit implements Serializable{
    private static final long serialVersionUID = -4170702480401121355L;
    
    @Schema(description = "Unique identifier of the Video Game.", 
            example = "1")
    private Integer videoGameIdx;
    
    @Schema(description = "Name of the Video Game.", 
            example = "Super Mario Bros", required = true)
    @NotBlank
    @Size(max = 50)
    private String title;
    
    @Schema(description = "synopsis of the Video Game.", 
            example = "The masterpiece of shigeru miyamoto",required = true)
    @NotBlank
    @Size(max = 500)
    private String description;
    
    @Schema(description = "Name of the development company", 
            example = "Konami", required = true)
    @NotBlank
    @Size(max = 80)
    private String developedBy;
    
    @Schema(description = "release year of the game", 
            example = "1993", required = true)
    @NotNull(message = "Please enter a number")
    @Min(value = 1970, message = "year should not be less than 1970")
    @Max(value = 2100, message = "year should not be greater than 2100")
    private Integer year;
    
    @Schema(description = "release year of the game", 
            example = "1", required = true)
    @NotNull(message = "Please enter a number")
    @Min(value = 1, message = "year should not be less than 1")
    @Max(value = 100, message = "year should not be greater than 100")
    private Integer players;
}
