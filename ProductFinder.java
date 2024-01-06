import java.util.ArrayList;

/**
 * Class designed to find the desired number and calculate the product
 * of its digits.
 * @author Rodrigo Casarin
 */
public class ProductFinder {
    
    private ArrayList<Long> numberList;
    private Long[] result;
    
    public ProductFinder(String number) {
	numberList = new ArrayList<>();
	
	for (int i = 0; i < number.length(); i++) {
	    if (number.charAt(i) == '\"')
		continue;
	    int element = 0;
	    element = number.charAt(i) - '0';
	    numberList.add((long)element);
	}
    }

    /*
     * Find the desired number with the received number of digits using a
     * comparison of two values each time. 
     */
    public Long[] findNumbers(int digits) {
	result = new Long[digits];
	
	// 'limit' variable represents the possible movements to traverse the number list.
	int limit = calculateLimit(digits);
	
	if (limit == 0) {
	    addNumbersToResult(0, digits);
	    return result;
	}
	
	int i = 0;
	int j = i + 1;
	
	while (limit != 0) {
	    long a = multiplyValues(i, digits);
	    long b = multiplyValues(j, digits);
	    
	    if (a >= b) {
		addNumbersToResult(i, digits);
		j++;
	    } else {
		addNumbersToResult(j, digits);
		i = j;
		j++;
	    }

	    limit--;
	}
	return result;
    }
    
    /*
     * Calculates the number of left positions based on the number of digits
     * of the desired number.
     */
    private int calculateLimit(int times) {
	if (times > numberList.size()) {
	    System.out.printf("It is not possible to obtain the result for those values.\n");
	    System.exit(1);
	}

	int limit = 0;
	int i = times - 1;
	while (i < numberList.size()) {
	    limit++;
	    i++;
	}
	return limit - 1;
    }
    
    /*
     * Adds the digits from the number list to the result starting in the
     * received index (start).
     */
    private void addNumbersToResult(int start, int times) {
	int j = start;
	try {
	    for (int i = 0; times != 0; i++) {
		result[i] = numberList.get(j);
		j++;
		times--;
	    }
	} catch (Exception abe) {
	    System.out.printf("It is not possible to obtain the result for those values.\n");
	    System.exit(1);
	}
    }

       
    /*
     * Multiply digits in the number list starting in the received index (start).
     */
    private Long multiplyValues(int start, int times) {
	long product = 1;
	try {
	    for (int i = start; times != 0; i++) {
		product = product * numberList.get(i);
		times--;
	    }
	} catch (IndexOutOfBoundsException ibe) {
	    System.out.printf("It is not possible to obtain the result for those values.\n");
	    System.exit(1);
	}
	return product;
    }

    /*
     * Calculates the total product of the stored elements in the result array.
     */
    public Long getTotalProduct() {
	long total = 1;
	for (int i = 0; i < result.length; i++)
	    total = total * result[i];
	return total;
    }
}
