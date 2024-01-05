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

    public Integer[] findNumbers(Integer digits) {
	result = new Integer[digits];
	int limit = calculateLimit(digits);
	if (limit == 0) {
	    addNumbersToResult(0, digits);
	    return result;
	}

	int i = 0;
	int j = i + 1;
	
	while (limit != 0) {
	    int a = multiplyValues(i, digits);
	    int b = multiplyValues(j, digits);

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
	    System.out.printf("It is not possible to obtain the result for those values3.\n");
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
	    abe.printStackTrace();
	    System.out.printf("It is not possible to obtain the result for those values2.\n");
	    System.exit(1);
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
	    ibe.printStackTrace();
	    System.exit(1);
	}
	return product;
    }
    
}
