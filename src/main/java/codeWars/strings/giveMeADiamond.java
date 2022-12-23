package codeWars.strings;

public class giveMeADiamond {
    /*
        Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.
        Task
        You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed,
        and every line must be terminated with a newline character (\n).
        Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.

        Examples
        A size 3 diamond:

         *
        ***
         *
        ...which would appear as a string of " *\n***\n *\n"

        A size 5 diamond:

          *
         ***
        *****
         ***
          *
        ...that is: " *\n ***\n*****\n ***\n *\n"
     */

    public static String print(int n) {
        if (n % 2 == 0 || n <= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int spaces = n / 2;
        int asterisk = 1;
        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(spaces));
            sb.append("*".repeat(asterisk));
            sb.append("\n");
            //once we get to the center of the diamond, we have to print the reverse so we add spaces and remove asterisk count
            if (i <= n / 2) {
                spaces -= 1;
                asterisk += 2;
            } else {
                spaces += 1;
                asterisk -= 2;
            }
        }
        return sb.toString();
    }

//    @Test
//    public void testDiamond3() {
//        StringBuffer expected = new StringBuffer();
//        expected.append(" *\n");
//        expected.append("***\n");
//        expected.append(" *\n");
//
//        assertEquals(expected.toString(), giveMeADiamond.print(3));
//    }
//
//    @Test
//    public void testDiamond5() {
//        StringBuffer expected = new StringBuffer();
//        expected.append("  *\n");
//        expected.append(" ***\n");
//        expected.append("*****\n");
//        expected.append(" ***\n");
//        expected.append("  *\n");
//
//        assertEquals(expected.toString(), giveMeADiamond.print(5));
//    }
//
//    @Test
//    public void testDiamond1() {
//        StringBuffer expected = new StringBuffer();
//        expected.append("*\n");
//        assertEquals(expected.toString(), giveMeADiamond.print(1));
//    }
//
//    @Test
//    public void testDiamond0() {
//        assertEquals(null, giveMeADiamond.print(0));
//    }
//
//    @Test
//    public void testDiamondMinus2() {
//        assertEquals(null, giveMeADiamond.print(-2));
//    }
//
//    @Test
//    public void testDiamond2() {
//        assertEquals(null, giveMeADiamond.print(2));
//    }


    public static void main(String[] args) {
        System.out.println(print(11));
    }
}
