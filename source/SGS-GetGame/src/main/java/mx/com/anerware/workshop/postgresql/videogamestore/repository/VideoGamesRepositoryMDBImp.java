package mx.com.anerware.workshop.postgresql.videogamestore.repository;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import mx.com.anerware.workshop.postgresql.
       videogamestore.repository.entity.VideoGameUnitMDB;

@Repository
public class VideoGamesRepositoryMDBImp implements 
    VideoGamesRepositoryMDB{

	//Mongo db client
	private final MongoClient client;
	private MongoCollection<VideoGameUnitMDB> videoGameCollection;
	
	public VideoGamesRepositoryMDBImp(MongoClient client) {
		this.client=client;
	}
	
	@PostConstruct
    void init() {
		videoGameCollection = client.getDatabase("VideoGamesDB").
        		getCollection("videoGames", VideoGameUnitMDB.class);
    }

	@Override
	public List<VideoGameUnitMDB> findByYear(int year) {
		return videoGameCollection.find(eq("year",year))
                .into(new ArrayList<>());
	}

	@Override
	public List<VideoGameUnitMDB> findByDevelopedBy(String developedBy) {
		return videoGameCollection.find(eq("developedBy",developedBy))
                .into(new ArrayList<>());
	}

	@Override
	public List<VideoGameUnitMDB> findByName(String name) {
		BasicDBObject query = new BasicDBObject();
		BasicDBObject regex = new BasicDBObject();
		regex.append("$regex",name);
		regex.append("$options","i");
		query.append("title", regex);				
		return videoGameCollection.find(query).into(new ArrayList<>());
	}
}
