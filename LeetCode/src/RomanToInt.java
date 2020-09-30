public class RomanToInt {

    // Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    public static int romanChecker(String s) {
        switch (s) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
        }
        return 0;
    }

    public static int romanToInt(String s) {
        int result = 0;
        char[] ar = s.toCharArray();
        int i = 0;


        for (i = 0; i < ar.length; i++) {

            //Check for special case of IV or IX
            if (ar[i] == 'V' || ar[i] == 'X') {
                if (i > 0 && ar[i - 1] == 'I') {
                    // in the case of IV, Since we add 1 + 5 we must subtract 2 to get 4
                    result -= 2;
                }
            }

            //Check for special case of XL or XC
            if (ar[i] == 'L' || ar[i] == 'C') {
                if (i > 0 && ar[i - 1] == 'X') {
                    // In the case of XL, we add 10 + 50 so to get 40 we sub 20
                    result -= 20;
                }
            }

            //Check for special case of CD or CM
            if (ar[i] == 'D' || ar[i] == 'M') {
                if (i > 0 && ar[i - 1] == 'C') {
                    result -= 200;
                }
            }
            result += romanChecker(String.valueOf(ar[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
