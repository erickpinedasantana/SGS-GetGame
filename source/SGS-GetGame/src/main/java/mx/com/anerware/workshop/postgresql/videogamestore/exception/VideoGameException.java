package mx.com.anerware.workshop.postgresql.videogamestore.exception;

public class VideoGameException extends RuntimeException{
	private static final long serialVersionUID = 1656074562083417678L;
	
	public VideoGameException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
