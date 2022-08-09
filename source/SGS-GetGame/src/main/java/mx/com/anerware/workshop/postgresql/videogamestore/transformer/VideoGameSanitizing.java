package mx.com.anerware.workshop.postgresql.videogamestore.transformer;

import mx.com.anerware.workshop.postgresql.videogamestore.transport.
VideoGameUnitTR;

public class VideoGameSanitizing {
	public static VideoGameUnitTR sanitizingInput(VideoGameUnitTR input) {
		VideoGameUnitTR newInput = new VideoGameUnitTR();
    	newInput.setDescription(validateInput(input.getDescription()));
    	newInput.setDevelopedBy(validateInput(input.getDevelopedBy()));
    	newInput.setTitle(validateInput(input.getTitle()));
    	newInput.setPlayers(input.getPlayers());
    	newInput.setVideoGameIdx(input.getVideoGameIdx());
    	newInput.setYear(input.getYear());
    	return newInput;
    }
    
    private static String validateInput(String str){
    	String data = null;
        if (str != null && str.length() > 0) {
          str = str.replace("\\", "\\\\");
          str = str.replace("'", "\\'");
          str = str.replace("\0", "\\0");
          str = str.replace("\n", "\\n");
          str = str.replace("\r", "\\r");
          str = str.replace("\"", "\\\"");
          str = str.replace("\\x1a", "\\Z");
          data = str;
        }
        return data;
    }
}
