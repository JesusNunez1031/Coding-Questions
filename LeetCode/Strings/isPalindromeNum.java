public class isPalindromeNum {

    public static String getReverse(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = str.length()-1;i >= 0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean isPalindrome(int x) {
        String numStr = String.valueOf(x);
        return getReverse(numStr).equals(numStr);
    }

    public static void main(String[] args) {
        System.out.print(isPalindrome(121));
    }
}
