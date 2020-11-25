import java.util.regex.Pattern;

public class GapFulNumbers {

    /*A gapful number is a number of at least 3 digits that is divisible by the number formed
    by the first and last digit of the original number

    Ex:
        input -> 192
        Output -> true (192 is a gapful because it is divisible by 12)
        input -> 583
        Output -> true (583 is a gapful because it is divisible by 53)
     */

    public static boolean isGapFul(int num) {
        int firstDigit = Integer.parseInt(Integer.toString(num).substring(0, 1));
        int lastDigit = num % 10;

        String div = firstDigit + "" + lastDigit + "";

//        Pattern isInteger = Pattern.compile("\\d+");
//        return isInteger.equals(num / Integer.parseInt(div));

        //check if the number is evenly divisible
        return num % Integer.parseInt(div) == 0;
    }

    public static void main(String[] args) {
        int number = 192;
        System.out.printf("%d is gapful: %s", number, isGapFul(number));
    }
}
