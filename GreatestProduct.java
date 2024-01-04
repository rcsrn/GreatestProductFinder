public class GreatestProduct {

    private static ProductFinder finder;
    private static final Integer DIGITS = 13;

    public static void main(String[] args) {
	
	String number = NumberReader.readNumberFromFile("input_number.txt");
	
	finder = new ProductFinder(number);
	
	int greatestProduct = finder.findGreatestProductOf(DIGITS);
	
	System.out.printf("This is the greatest %d adjacent digits product: %d\n",
			  DIGITS,
			  greatestProduct);
    }
}
