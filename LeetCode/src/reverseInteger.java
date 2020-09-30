public class reverseInteger {
    //Given an integer number, return it reversed. if the number overflows 2^31, return 0 instead

    public static int reverse(int x) {
        long result = 0;
        while(x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result> Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) result;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
