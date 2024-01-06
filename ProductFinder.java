import java.util.ArrayList;

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

    public Long[] findNumbers(int digits) {
	result = new Long[digits];
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

    public Long getTotalProduct() {
	long total = 1;
	for (int i = 0; i < result.length; i++)
	    total = total * result[i];
	return total;
    }
}
