public class GreatestProduct {

    private static ProductFinder finder;
    private static final Integer DIGITS = 13;

    public static void main(String[] args) {
	
	String number = NumberReader.readNumberFromFile("input_number.txt");
	
	finder = new ProductFinder(number);
	
	Integer[] numbers = finder.findNumbers(DIGITS);
	
	System.out.printf("The %d adjacent digits in the 1000-digit number that have the greatest product are: %s\n",
			  DIGITS,
			  numbers);
    }
}
