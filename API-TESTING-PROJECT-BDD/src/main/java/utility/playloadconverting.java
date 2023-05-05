package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class playloadconverting {
 public static String generateplayloadstring(String filename) throws IOException{
	 String filepath =System.getProperty("user.dir")+"/src/main/resources/" + filename;
			 System.err.println(filepath);
	 return new String(Files.readAllBytes(Paths.get(filepath)));		 
 }
}
//C:\Users\Abhay Pathak\eclipse-workspace\API-Testing-Framework\src\main\java\resource\createRepo.json