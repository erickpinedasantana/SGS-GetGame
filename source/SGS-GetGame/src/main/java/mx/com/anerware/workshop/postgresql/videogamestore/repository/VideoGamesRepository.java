package mx.com.anerware.workshop.postgresql.videogamestore.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.anerware.workshop.postgresql.videogamestore.repository.entity.
VideoGameUnitBD;

public interface VideoGamesRepository extends 
                                      JpaRepository<VideoGameUnitBD, Integer>{
	
	@Query(value = "SELECT video_game_idx, title, description, developed_by, "+
		           "years, players from public.video_games " +
		           "where video_game_idx = :idx", nativeQuery=true)
    VideoGameUnitBD findVideoGameByIdxVideGame(@Param("idx") Integer idx) 
	        throws IllegalArgumentException, EntityNotFoundException;

    @Query(value = "SELECT video_game_idx, title, description, developed_by, "+
	           "years, players from public.video_games " +
	           "where years = :year", nativeQuery=true)
    List<VideoGameUnitBD> findVideoGameByYear(@Param("year") Integer year) 
            throws IllegalArgumentException, EntityNotFoundException;
	
	@Query(value = "SELECT video_game_idx, title, description, developed_by, "+
		       "years, players from public.video_games " +
		       "where title like %:name%", nativeQuery=true)
	List<VideoGameUnitBD> findVideoGameByName(@Param("name") String name) 
	throws IllegalArgumentException, EntityNotFoundException;
}
