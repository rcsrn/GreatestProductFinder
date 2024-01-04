import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class NumberReader {
    
    public static String readNumberFromFile(String path) {
	String input = "";
	try (BufferedReader in = new BufferedReader(new FileReader(path))) {
	    String line;
	    StringBuilder builder = new StringBuilder();
	    while((line = in.readLine()) != null) {
		builder.append(line);
	    }
	    
	    input = builder.toString();
	    
	} catch (IOException ioe) {
	    System.out.printf("It is not possible to read from %s\n",
			      path);
	    System.exit(1);
	}
	
	 return input;
    } 
}
