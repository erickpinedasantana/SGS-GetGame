package mx.com.anerware.workshop.postgresql.videogamestore.service;

import java.util.List;

import mx.com.anerware.workshop.postgresql.videogamestore.exception.VideoGameException;
import mx.com.anerware.workshop.postgresql.videogamestore.transport.VideoGameUnitTR;

public interface SuperGameStoreService {
     
     public VideoGameUnitTR getGameByIdx (Integer idx) 
    		 throws VideoGameException;
     
     public List<VideoGameUnitTR> getGameByYear (Integer year) 
    		 throws VideoGameException;
     
     public List<VideoGameUnitTR> getGameByName (String name) 
    		 throws VideoGameException;
}
