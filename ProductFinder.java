import java.util.ArrayList;

public class ProductFinder {
    
    private ArrayList<Integer> numberList;
    private Integer[] result;
    
    public ProductFinder(String number) {
	numberList = new ArrayList<>();
	
	for (int i = 0; i < number.length(); i++) {
	    if (number.charAt(i) == '\"')
		continue;
	    int element = 0;
	    element = number.charAt(i) - '0';
	    numberList.add(element);
	}
       
    }   

    public Integer findNumbers(Integer digits) {
	result = new Integer[digits];
	int i = 0;
	int j = i + 1;
	int count = numberList.size();
	while (count-- != 0) {
	    int a = multiplyValues(i, digits);
	    int b = multiplyValues(j, digits);
	    if (a >= b) {
		
	    } else {
		
	    }
	}
	return result.length;
    }

    private void addNumbersToResult(int start, int times) {
	int j = start;
	for (int i = 0; times != 0; i++) {
	    result[i] = numberList.get(j++);
	    times--;
	}
    }
    
    private Integer multiplyValues(int start, int times) {
	int product = 1;
	try {
	    for (int i = start; times != 0; i++) {
		product = product * numberList.get(i);
		times--;
	    }
	} catch (IndexOutOfBoundsException ibe) {
	    System.out.printf("It is not possible to obtain the number\n");
	    System.exit(1);
	}
	return product;
    }
    
}
