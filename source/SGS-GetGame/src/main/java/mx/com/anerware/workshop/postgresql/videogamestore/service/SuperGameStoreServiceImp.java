package mx.com.anerware.workshop.postgresql.videogamestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.anerware.workshop.postgresql.videogamestore.exception.
VideoGameException;
import mx.com.anerware.workshop.postgresql.videogamestore.repository.VideoGamesRepository;
import mx.com.anerware.workshop.postgresql.videogamestore.repository.entity.VideoGameUnitBD;
import mx.com.anerware.workshop.postgresql.videogamestore.transformer.VideoGameTransformer;
import mx.com.anerware.workshop.postgresql.videogamestore.transport.
VideoGameUnitTR;

@Service
@Transactional
public class SuperGameStoreServiceImp implements SuperGameStoreService{
	
	@Autowired
	private VideoGamesRepository videoGamesRepository;
	
	@Override
	public VideoGameUnitTR getGameByIdx (Integer idx) 
			 throws VideoGameException{
		VideoGameUnitTR videoGameUnitTR = null;
		try {	
			VideoGameUnitBD videoGameDB = videoGamesRepository.
					                      findVideoGameByIdxVideGame(idx);
			videoGameUnitTR = VideoGameTransformer.map(videoGameDB, 
					                      VideoGameUnitTR.class);
		}catch(Exception e) {
			throw new VideoGameException("Se ha generado un error: "
		                                 + e.getMessage(),e);
		}
		return videoGameUnitTR;
	}

	@Override
	public List<VideoGameUnitTR> getGameByYear(Integer year) 
			            throws VideoGameException{
		List<VideoGameUnitTR> videoGames= null;
		try {
			List<VideoGameUnitBD> listGames = videoGamesRepository.
                    findVideoGameByYear(year);
			videoGames = VideoGameTransformer.mapAll(listGames, 
			VideoGameUnitTR.class);
		}catch(Exception e) {
			throw new VideoGameException("Se ha generado un error: "
		                                 + e.getMessage(),e);
		}
	
		return videoGames;
	}
	
	@Override
	public List<VideoGameUnitTR> getGameByName(String name) 
			            throws VideoGameException{
		List<VideoGameUnitTR> videoGames= null;
		try {
			List<VideoGameUnitBD> listGames = videoGamesRepository.
                    findVideoGameByName(name);
			videoGames = VideoGameTransformer.mapAll(listGames, 
			VideoGameUnitTR.class);
		}catch(Exception e) {
			throw new VideoGameException("Se ha generado un error: "
		                                 + e.getMessage(),e);
		}
	
		return videoGames;
	}

}