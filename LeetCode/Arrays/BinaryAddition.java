public class BinaryAddition {

//    public static String addBinary(String a, String b) {
//        if (a.length() == 1 && b.length() == 1) {
//            if (a.charAt(0) == '1' && b.charAt(0) == '1')
//                return "10";
//            else
//                return a.charAt(0) == '0' && b.charAt(0) == '0' ? "0" : "1";
//        }
//        long aVal = Long.parseLong(a);
//        long bVal = Long.parseLong(b);
//        int i = 0, remainder = 0;
//        StringBuilder sb = new StringBuilder();
//
//        int[] sum = new int[20];
//
//        while (aVal != 0 || bVal != 0) {
//            sum[i++] = (int) ((aVal % 10 + bVal % 10 + remainder) % 2);
//            remainder = (int) ((aVal % 10 + bVal % 10 + remainder) / 2);
//            aVal = aVal / 10;
//            bVal = bVal / 10;
//        }
//
//        if (remainder != 0) {
//            sum[i++] = remainder;
//        }
//        --i;
//        while (i >= 0) {
//            sb.append(sum[i--]);
//        }
//        return sb.toString();
//    }

    //LeetCode Solution
    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            //Check to make sure we dont go out of bounds
            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';

            //If the the sum is 2, we need it to be odd since 2 does not exist in binary
            result.append(sum % 2);

            //if sum is 2, we get a carry of 1, in the case sum is 1, carry will be 0
            carry = sum / 2;

            //Decrement pointers
            i--;
            j--;
        }

        //If our program finished with a carry, we need to add it to the sum
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10";
        String b = "1";

        System.out.println(addBinary(a, b));
    }
}
