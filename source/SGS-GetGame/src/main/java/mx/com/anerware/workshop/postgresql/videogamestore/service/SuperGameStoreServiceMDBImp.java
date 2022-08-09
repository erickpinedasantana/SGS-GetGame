package mx.com.anerware.workshop.postgresql.videogamestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.anerware.workshop.postgresql.videogamestore.exception.VideoGameException;
import mx.com.anerware.workshop.postgresql.videogamestore.repository.VideoGamesRepositoryMDB;
import mx.com.anerware.workshop.postgresql.videogamestore.repository.entity.VideoGameUnitMDB;
import mx.com.anerware.workshop.postgresql.videogamestore.transformer.VideoGameTransformer;
import mx.com.anerware.workshop.postgresql.videogamestore.transport.VideoGameUnitTR;

@Service
public class SuperGameStoreServiceMDBImp implements SuperGameStoreServiceMDB{

	@Autowired
	private VideoGamesRepositoryMDB videoGameRepositoryMDB;
	
    @Override
	public List<VideoGameUnitTR> findByDevelopedBy(String developedBy) {
		List<VideoGameUnitTR> videoGames= null;
		try {
			List<VideoGameUnitMDB> listGames = 
					videoGameRepositoryMDB.findByDevelopedBy(developedBy);
			
			videoGames = VideoGameTransformer.mapAll(listGames, 
					VideoGameUnitTR.class);
		}catch(Exception e) {
			throw new VideoGameException("Se ha generado un error: "
			                                  + e.getMessage(),e);
		}
		return videoGames;
	}

	@Override
	public List<VideoGameUnitTR> findByYear(int year) {
		List<VideoGameUnitTR> videoGames= null;
		try {
			List<VideoGameUnitMDB> listGames = 
					videoGameRepositoryMDB.findByYear(year);
			
			videoGames = VideoGameTransformer.mapAll(listGames, 
					VideoGameUnitTR.class);
		}catch(Exception e) {
			throw new VideoGameException("Se ha generado un error: "
			                                  + e.getMessage(),e);
		}
		return videoGames;
	}

	@Override
	public List<VideoGameUnitTR> findByName(String name) {
		List<VideoGameUnitTR> videoGames= null;
		try {
			List<VideoGameUnitMDB> listGames = 
					videoGameRepositoryMDB.findByName(name);
			
			videoGames = VideoGameTransformer.mapAll(listGames, 
					VideoGameUnitTR.class);
		}catch(Exception e) {
			throw new VideoGameException("Se ha generado un error: "
			                                  + e.getMessage(),e);
		}
		return videoGames;
	}

}
