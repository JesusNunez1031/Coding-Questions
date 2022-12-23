//public class nextSmallerNumberWithSameDigits {
//
//    public static long nextSmaller(long n) {
//        StringBuilder num = new StringBuilder(String.valueOf(n));
//        //if the length of the number is 1, there is no possible smaller number, so return -1
//        if (num.length() == 1) {
//            return -1;
//        }
//
//        //if the number is 2 digits, return its reverse iff the second digit is less than the first digit
//        if (num.length() == 2) {
//            if (n % 10 < n / 10) {
//                return Long.parseLong(num.reverse().toString());
//            } else {
//                return -1;
//            }
//        }
//
//        char[] arr = num.toString().toCharArray();
//        int i = arr.length - 1, j = arr.length-2;
//
//        while(j >= 0) {
//            if((int)arr[i] < (int)arr[j]) {
//                char temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                j--;
//                i--;
//                if(Long.parseLong(String.valueOf(arr)) < n) {
//                    return Long.parseLong(String.valueOf(arr));
//                }
//            } else {
//                j--;
//            }
//        }
//        return -1;
//    }
//
//
//    public static void main(String[] args) {
//        long num = 123456798;
//
//        System.out.println(nextSmaller(num));
//    }
//}
