import java.util.ArrayList;

public class ProductFinder {
    
    private ArrayList listNumber;
    
    public ProductFinder(String number) {
	for (int i = 0; i < number.length(); i++) {
	    if (number.charAt(i) == '\"')
		continue;
	    int element = 0;
	    element = number.charAt(i) - '0';
	    System.out.print(element);
	}
    }

    public Integer findGreatestProductOf(Integer digits) {
	return 0;
    }
    
}
