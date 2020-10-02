//public class ImplementStrStr {
//
//    public static int strStr(String haystack, String needle) {
//        if(needle.length() == 0) {
//            return 0;
//        }
//        int value = 0;
//        while(haystack.indexOf(needle) != 0) {
//            if(needle.equals(haystack.substring(value, haystack.length()-1))){
//                return value;
//            }
//            else {
//                value++;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        String haystack = "confungus";
//        String needle = "fun";
//
//        System.out.println(strStr(haystack,needle));
//    }
//}
