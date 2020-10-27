import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.

    Example:
    Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 */
public class createPhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length > 10) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                sb.append("(");
            } else if (i == 3) {
                sb.append(") ");
            } else if (i == 6) {
                sb.append("-");
            }
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    @Test
    public void tests() {
        assertEquals("(123) 456-7890", createPhoneNumber.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(createPhoneNumber(numbers));
    }
}
