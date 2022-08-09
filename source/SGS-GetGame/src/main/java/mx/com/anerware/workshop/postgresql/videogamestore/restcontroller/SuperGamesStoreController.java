package mx.com.anerware.workshop.postgresql.videogamestore.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.com.anerware.workshop.postgresql.videogamestore.restobj.VGGetRes;
import mx.com.anerware.workshop.postgresql.videogamestore.restobj.
VideoGameUnit;
import mx.com.anerware.workshop.postgresql.videogamestore.service.SuperGameStoreService;
import mx.com.anerware.workshop.postgresql.videogamestore.service.SuperGameStoreServiceMDB;
import mx.com.anerware.workshop.postgresql.videogamestore.transformer.
VideoGameTransformer;
import mx.com.anerware.workshop.postgresql.videogamestore.transport.
VideoGameUnitTR;

@RestController
@RequestMapping("/")
@Tag(name = "Super Games Store", description="API Rest for Video Games")
public class SuperGamesStoreController {

	@Autowired
	private SuperGameStoreService superGameStoreService;
	
	@Autowired
	private SuperGameStoreServiceMDB superGameStoreServiceMDB;
	
	/**
	 * 
	 * @param videoGameIdx
	 * @return
	 */
	@Operation(summary = "Obtain a Video Game",
			  description = "Obtain a Video Game from Store",
			  tags = {"Get Video Games", "Obtain Video Games"}
			)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", 
	    description = "Success Operation",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "400",
	    description = "Bad Request error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "500",
	    description = "Internal VideoGames Services error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class)))
	})
	@GetMapping(value="/getBy/{videoGameIdx}/idx",  
	            produces = { "application/json", "application/xml" })
	public ResponseEntity<VGGetRes> getVideoGamesByVideoGameIdx(
			@PathVariable("videoGameIdx") Integer videoGameIdx){
		try {
			
			VideoGameUnitTR videoGame = superGameStoreService
                    .getGameByIdx(videoGameIdx);

			VGGetRes response = new VGGetRes();
			response.setCode("00");
			response.setDescription("Process completed");
			response.setExtraInfo("1 Game Finded");
			response.setVideoGames(new ArrayList<VideoGameUnit>());
			response.getVideoGames().add(VideoGameTransformer.
			map(videoGame, VideoGameUnit.class));
			
			return new ResponseEntity<VGGetRes>(response, HttpStatus.OK);
		}catch(Exception e) {
			VGGetRes response = new VGGetRes();
			response.setCode("01");
			response.setDescription("Internal service error "
					              + "get VideoGames by idx");
			response.setExtraInfo("Exception: "+e.toString());
			return new ResponseEntity<VGGetRes>(response, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param videoGameYear
	 * @return
	 */
	@Operation(summary = "Obtain a Video Games",
			  description = "Obtain a Video Games from Store by year",
			  tags = {"Get Video Games", "Obtain Video Games"}
			)
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", 
	    description = "Success Operation",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "400",
	    description = "Bad Request error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "500",
	    description = "Internal VideoGames Services error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class)))
	})
	@GetMapping(value="/getBy/{videoGameYear}/year",  
	            produces = { "application/json", "application/xml" })
	public ResponseEntity<VGGetRes> getVideoGamesByVideoGameYear(
			@PathVariable("videoGameYear") Integer videoGameYear){
		try {
			List<VideoGameUnitTR> videoGames = superGameStoreService.
                    getGameByYear(videoGameYear);
			
			List<VideoGameUnit> videoGamesResp = VideoGameTransformer.
			                    mapAll(videoGames, VideoGameUnit.class);
			VGGetRes response = new VGGetRes();
			response.setVideoGames(videoGamesResp);
			response.setCode("00");
			response.setDescription("Process completed");
			response.setExtraInfo(response.getVideoGames().size() 
					 + " Games Finded");
			return new ResponseEntity<VGGetRes>(response, HttpStatus.OK);
		}catch(Exception e) {
			VGGetRes response = new VGGetRes();
			response.setCode("01");
			response.setDescription("Internal service error "
					              + "get VideoGames by year");
			response.setExtraInfo("Exception: "+e.getMessage());
			return new ResponseEntity<VGGetRes>(response, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param videoGameName
	 * @return
	 */
	@Operation(summary = "Obtain a Video Games",
			  description = "Obtain a Video Games from Store by name",
			  tags = {"Get Video Games", "Obtain Video Games"}
			)
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", 
	    description = "Success Operation",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "400",
	    description = "Bad Request error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "500",
	    description = "Internal VideoGames Services error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class)))
	})
	@GetMapping(value="/getBy/{videoGameName}/name",  
	            produces = { "application/json", "application/xml" })
	public ResponseEntity<VGGetRes> getVideoGamesByVideoGameName(
			@PathVariable("videoGameName") String videoGameName){
		try {
			List<VideoGameUnitTR> videoGames = superGameStoreService.
                    getGameByName(videoGameName);
			List<VideoGameUnit> videoGamesResp = VideoGameTransformer.
			                    mapAll(videoGames, VideoGameUnit.class);
			VGGetRes response = new VGGetRes();
			response.setVideoGames(videoGamesResp);
			response.setCode("00");
			response.setDescription("Process completed");
			response.setExtraInfo(response.getVideoGames().size() 
					 + " Games Finded");
			return new ResponseEntity<VGGetRes>(response, HttpStatus.OK);
		}catch(Exception e) {
			VGGetRes response = new VGGetRes();
			response.setCode("01");
			response.setDescription("Internal service error "
					              + "get VideoGames by year");
			response.setExtraInfo("Exception: "+e.getMessage());
			return new ResponseEntity<VGGetRes>(response, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/***********************************************************************/
	/**
	 * 
	 * @param videoGameIdx
	 * @return
	 */
	@Operation(summary = "Obtain a Video Game",
			  description = "Obtain a Video Game from Store",
			  tags = {"Get Video Games", "Obtain Video Games"}
			)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", 
	    description = "Success Operation",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "400",
	    description = "Bad Request error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "500",
	    description = "Internal VideoGames Services error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class)))
	})
	@GetMapping(value="/mdb/getBy/{videoGameDevelop}/develop",  
	            produces = { "application/json", "application/xml" })
	public ResponseEntity<VGGetRes> getVideoGamesMdbByDevelopBy(
			@PathVariable("videoGameDevelop") String videoGameDevelop){
		try {
			List<VideoGameUnitTR> listGames =
			    superGameStoreServiceMDB.findByDevelopedBy(videoGameDevelop);
			
			List<VideoGameUnit> videoGames = 
				VideoGameTransformer.mapAll(listGames, VideoGameUnit.class);

			VGGetRes response = new VGGetRes();
			response.setCode("00");
			response.setDescription("Process completed");
			response.setVideoGames(videoGames);
			response.setExtraInfo(response.getVideoGames().size() 
					 + " Games Finded");
			
			return new ResponseEntity<VGGetRes>(response, HttpStatus.OK);
		}catch(Exception e) {
			VGGetRes response = new VGGetRes();
			response.setCode("01");
			response.setDescription("Internal service error "
					              + "get VideoGames by idx");
			response.setExtraInfo("Exception: "+e.toString());
			return new ResponseEntity<VGGetRes>(response, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param videoGameYear
	 * @return
	 */
	@Operation(summary = "Obtain a Video Games",
			  description = "Obtain a Video Games from Store by year",
			  tags = {"Get Video Games", "Obtain Video Games"}
			)
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", 
	    description = "Success Operation",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "400",
	    description = "Bad Request error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "500",
	    description = "Internal VideoGames Services error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class)))
	})
	@GetMapping(value="/mdb/getBy/{videoGameYear}/year",  
	            produces = { "application/json", "application/xml" })
	public ResponseEntity<VGGetRes> getVideoGamesMdbByVideoGameYear(
			@PathVariable("videoGameYear") Integer videoGameYear){
		try {
			    List<VideoGameUnitTR> listGames =
				    superGameStoreServiceMDB.findByYear(videoGameYear);
				
				List<VideoGameUnit> videoGames = 
					VideoGameTransformer.mapAll(listGames, VideoGameUnit.class);

				VGGetRes response = new VGGetRes();
				response.setCode("00");
				response.setDescription("Process completed");
				response.setVideoGames(videoGames);
				response.setExtraInfo(response.getVideoGames().size() 
						 + " Games Finded");
				
				return new ResponseEntity<VGGetRes>(response, HttpStatus.OK);
		}catch(Exception e) {
			VGGetRes response = new VGGetRes();
			response.setCode("01");
			response.setDescription("Internal service error "
					              + "get VideoGames by year");
			response.setExtraInfo("Exception: "+e.getMessage());
			return new ResponseEntity<VGGetRes>(response, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param videoGameYear
	 * @return
	 */
	@Operation(summary = "Obtain a Video Games",
			  description = "Obtain a Video Games from Store by name",
			  tags = {"Get Video Games", "Obtain Video Games"}
			)
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", 
	    description = "Success Operation",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "400",
	    description = "Bad Request error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class))),
	    @ApiResponse(responseCode = "500",
	    description = "Internal VideoGames Services error",
	    content = @Content(schema = @Schema(implementation = VGGetRes.class)))
	})
	@GetMapping(value="/mdb/getBy/{videoGameName}/name",  
	            produces = { "application/json", "application/xml" })
	public ResponseEntity<VGGetRes> getVideoGamesMdbByVideoGameName(
			@PathVariable("videoGameName") String videoGameName){
		try {
			List<VideoGameUnitTR> listGames =
				    superGameStoreServiceMDB.findByName(videoGameName);
				
				List<VideoGameUnit> videoGames = 
					VideoGameTransformer.mapAll(listGames, VideoGameUnit.class);

				VGGetRes response = new VGGetRes();
				response.setCode("00");
				response.setDescription("Process completed");
				response.setVideoGames(videoGames);
				response.setExtraInfo(response.getVideoGames().size() 
						 + " Games Finded");
				
				return new ResponseEntity<VGGetRes>(response, HttpStatus.OK);
		}catch(Exception e) {
			VGGetRes response = new VGGetRes();
			response.setCode("01");
			response.setDescription("Internal service error "
					              + "get VideoGames by year");
			response.setExtraInfo("Exception: "+e.getMessage());
			return new ResponseEntity<VGGetRes>(response, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
