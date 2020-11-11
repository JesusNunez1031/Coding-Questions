public class strStr {

    //Method to convert the string to a unique hashcode value
    public static long getValue(String s) {
        long num = 0;
        int power = s.length() - 1;

        for (char n : s.toCharArray()) {
            num += (n - 'a') * Math.pow(2, power--);
        }
        return num;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        //if the needle is larger than haystack, its not possible to find needle in haystack
        if (needle.length() > haystack.length()) {
            return -1;
        }


        long needVal = getValue(needle);
        int i = 0;

        while (i <= haystack.length() - needle.length()) {
            //get the substring of needle length from haystack
            String str = haystack.substring(i, i + needle.length());

            //if the hashcode value of the needle matches the hashcode value of str, we found a match
            if (needVal == getValue(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        //String haystack = "ababcaababcaabc";
        //String needle = "ababcaabc";
        String haystack = "abbbbbaabbaabaabbbaaaaabbabbbabbbbbaababaabbaabbbbbababaababbbbaaabbbbabaabaaaabbbbabbbaabbbaabbaaabaabaaaaaaaa";
        String needle = "abbbaababbbabbbabbbbbabaaaaaaabaabaabbbbaabab";

        System.out.println(strStr(haystack, needle));
    }
}
