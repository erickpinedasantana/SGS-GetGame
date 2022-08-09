package mx.com.anerware.workshop.postgresql.videogamestore.repository;

import java.util.List;

import mx.com.anerware.workshop.postgresql.videogamestore.
       repository.entity.VideoGameUnitMDB;

public interface VideoGamesRepositoryMDB {
	List<VideoGameUnitMDB> findByDevelopedBy(String developedBy);
	
	List<VideoGameUnitMDB> findByYear(int year);
	
	List<VideoGameUnitMDB> findByName(String name);
}
