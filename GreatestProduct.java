import java.lang.StringBuilder;

public class GreatestProduct {

    private static ProductFinder finder;
    private static final Integer DIGITS = 13;

    public static void main(String[] args) {
	
	String number = NumberReader.readNumberFromFile("input_number.txt");
	
	finder = new ProductFinder(number);
	
	Integer[] numbers = finder.findNumbers(DIGITS);
	
	StringBuilder builder = new StringBuilder();

	for (int i = 0; i < numbers.length; i++)
	    builder.append(numbers[i].toString() + " × ");
	
	System.out.printf("The %d adjacent digits in the 1000-digit number that have the greatest product are: %s = %s\n",
			  DIGITS,
			  builder.toString(),
			  finder.getTotalProduct());
    }
}
