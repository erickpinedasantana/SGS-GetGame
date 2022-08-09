package mx.com.anerware.workshop.postgresql.videogamestore.restobj;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class VGGetRes extends VideoGameGeneralData{
	private static final long serialVersionUID = -573109674063048219L;
	private List<VideoGameUnit> videoGames;
}
