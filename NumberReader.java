import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberReader {
    
    public static Integer readNumberFromFile(String path) {
	
	try (BufferedReader input = new BufferedReader(new FileReader(path))) {
	    return 1;
	} catch (IOException ioe) {
	    System.out.printf("It is not possible to read from %s\n",
			      path);
	    System.exit(1);
	}
	return -1;
    }
    
}
