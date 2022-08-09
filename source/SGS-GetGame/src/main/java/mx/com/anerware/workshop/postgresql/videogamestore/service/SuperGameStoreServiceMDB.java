package mx.com.anerware.workshop.postgresql.videogamestore.service;

import java.util.List;

import mx.com.anerware.workshop.postgresql.videogamestore.transport.VideoGameUnitTR;

public interface SuperGameStoreServiceMDB {
     public List<VideoGameUnitTR> findByDevelopedBy(String developedBy);
 	
     public List<VideoGameUnitTR> findByYear(int year);
 	
     public List<VideoGameUnitTR> findByName(String name);
}
