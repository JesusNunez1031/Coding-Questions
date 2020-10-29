import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class stringNumberToInteger {
    /*
    In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

    Examples:

    "one" => 1
    "twenty" => 20
    "two hundred forty-six" => 246
    "seven hundred eighty-three thousand nine hundred and nineteen" => 783919

    Additional Notes:
    The minimum number is "zero" (inclusively)
    The maximum number, which must be supported is 1 million (inclusively)
    The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
    All tested numbers are valid, you don't need to validate them
     */
    static Map<String, Integer> numbers = new HashMap<>() {{
        this.put("zero", 0);
        this.put("one", 1);
        this.put("two", 2);
        this.put("three", 3);
        this.put("four", 4);
        this.put("five", 5);
        this.put("six", 6);
        this.put("seven", 7);
        this.put("eight", 8);
        this.put("nine", 9);
        this.put("ten", 10);
        this.put("eleven", 11);
        this.put("twelve", 12);
        this.put("thirteen", 13);
        this.put("fourteen", 14);
        this.put("fifteen", 15);
        this.put("sixteen", 16);
        this.put("seventeen", 17);
        this.put("eighteen", 18);
        this.put("nineteen", 19);
        this.put("twenty", 20);
        this.put("thirty", 30);
        this.put("forty", 40);
        this.put("fifty", 50);
        this.put("sixty", 60);
        this.put("seventy", 70);
        this.put("eighty", 80);
        this.put("ninety", 90);
        this.put("hundred", 100);
        this.put("thousand", 1000);
        this.put("million", 1000000);
    }};

    public static int parseInt(String str) {
        str = str.replaceAll("-", " ");
        if (numbers.containsKey(str)) {
            return numbers.get(str);
        }

        //makeArray will take the string number and turn it into an arraylist of integer numbers
        List<Integer> list = makeArray(str);

        int total = 0;
        //check if there is 1000 or 1000000
        int indexOfThousand = list.indexOf(1000);
        int indexOfMillion = list.indexOf(1000000);
        //if the number has a million, we are going to have to calculate values up to it return and then calculate numbers up to thousand return, and then the rest of the values
        if (indexOfThousand > 0 && indexOfMillion > 0) {
            int first = getValue(0, indexOfMillion, list);
            int second = getValue(indexOfMillion + 1, indexOfThousand, list);
            int third = getValue(indexOfThousand + 1, list.size(), list);

            total = first + second + third;
        } else if (indexOfMillion < 0 && indexOfThousand > 0) {
            int left = getValue(0, indexOfThousand, list);
            int right = getValue(indexOfThousand + 1, list.size(), list);
            total = left + right;
        } else {
            total = getValue(0, list.size(), list);
        }
        return total == 0 ? -1 : total;
    }

    //Turn the number string entered into an arraylist of numbers
    public static List<Integer> makeArray(String stringNum) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < stringNum.length(); i++) {
            if (stringNum.charAt(i) == ' ') {
                if (numbers.containsKey(sb.toString())) {
                    nums.add(numbers.get(sb.toString()));
                }
                sb = new StringBuilder();
                i++;
            }
            sb.append(stringNum.charAt(i));

            if (i == stringNum.length() - 1) {
                nums.add(numbers.get(sb.toString()));
            }
        }
        return nums;
    }

    public static int getValue(int start, int end, List<Integer> nums) {
        int sum = 0;
        if (end == nums.size()) {
            for (int i = start; i < end; i++) {
                if (nums.get(i) == 1000000) {
                    sum *= 1000000;
                } else if (nums.get(i) == 1000) {
                    sum *= 1000;
                } else if (nums.get(i) == 100) {
                    sum *= 100;
                } else {
                    sum += nums.get(i);
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (nums.get(i) == 1000000) {
                    sum *= 1000000;
                } else if (nums.get(i) == 1000) {
                    sum *= 1000;
                } else if (nums.get(i) == 100) {
                    sum *= 100;
                } else {
                    sum += nums.get(i);
                }
            }
        }
        return sum;
    }

    @Test
    public void fixedTests() {
        assertEquals(1, stringNumberToInteger.parseInt("one"));
        assertEquals(20, stringNumberToInteger.parseInt("twenty"));
        assertEquals(246, stringNumberToInteger.parseInt("two hundred forty-six"));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //String stringNum = "seven hundred eighty-three thousand nine hundred and nineteen";
        //String stringNum = "ten thousand forty-five".replaceAll("-", " ");
        //String stringNum = "forty-seven million two hundred fifty-eight thousand one hundred thirteen";
        String stringNum = "nine hundred ninety-nine million nine hundred ninety nine thousand nine hundred ninety nine";

        System.out.println(parseInt(stringNum));


    }
}
