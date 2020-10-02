import java.util.Arrays;

public class CountingValleys {


    // Method to find valleys given actual string path
    public static int countingValleys(String path) {
        char[] arr = path.toCharArray();
        int seaLevel = 0, valleys = 0, U = 0, D = 0;

        for (char chars : arr) {
            if (chars == '_') {
                if (seaLevel != 0) {
                    seaLevel--;
                } else {
                    seaLevel++;
                }
            } else if (chars == '/') {
                U++;
            } else if (chars == '\\') {
                D++;
            } else if (seaLevel == 0 && U == D) {
                valleys++;
                seaLevel++;
            }
        }
        return valleys;
    }

    public static int countingValleys(int steps, String path) {
        int v = 0, valleys = 0;
        for(int i = 0;i < steps;i++) {
            if(path.charAt(i) == 'U') {
                v++;
            }
            else {
                v--;
            }
            if(v == 0 && path.charAt(i) == 'U') {
                valleys++;
            }
        }
        return valleys;
    }

    static long repeatedString(String s, long n) {
        long count = 0;
        for(long i = 0; i < n;i++){
            if (s.charAt((int) i) == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String valley = "_/\\      _\n" +
//                "   \\    /\n" +
//                "    \\/\\/";
//
//        System.out.println(countingValleys(valley));

        System.out.println(countingValleys(100, "DDUDUDDUDDUDDUUUUDUDDDUUDDUUDDDUUDDUUUUUUDUDDDDUDDUUDUUDUDUUUDUUUUUDDUDDDDUDDUDDDDUUUUDUUDUUDUUDUDDD"));

    }
}
