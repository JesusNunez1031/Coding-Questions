package leetCode.strings;

public class reconstructOriginalDigitsFromEnglish {
    /*
    Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

    Note:
        1. Input contains only lowercase English letters.
        2. Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
        3. Input length is less than 50,000.

    Example 1:
    Input: "owoztneoer"
    Output: "012"

    Example 2:
    Input: "fviefuro"
    Output: "45"
     */
    //TC: O(n) and constant space since 26 and 10 don't take up enough space to count
    public String originalDigits(String s) {
        /*
            zero -> 0      five  -> 5
            one  -> 1      six   -> 6
            two  -> 2      seven -> 7
            three -> 3     eight -> 8
            four -> 4      nine  -> 9

            numbers with unique characters are zero(z), two(w), four(u), six(x), and eight(g), so to we count the number
            of times these unique characters show up and this will indicate how many times these numbers are in S

            To get the rest of the numbers, we take the count of letter needed to make the string number but subtract the
            letters that also appear in other numbers with the same used letter
            Ex:
                five(f), f is also in four so we subtract count of four
                one(o), o is also in zero, two, and four, so we subtract the count of these values
                three(t), t is also in eight and two
                seven(s), s is also in six
                nine(i), i is also in five, six, eight
        */

        //frequency array to hold the count of all letters in s, all letters are lowercase
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        //array to hold the count of each number in s, 9 possible digits
        int[] nums = new int[10];

        //numbers with unique characters
        nums[0] = freq['z' - 'a'];
        nums[2] = freq['w' - 'a'];
        nums[4] = freq['u' - 'a'];
        nums[6] = freq['x' - 'a'];
        nums[8] = freq['g' - 'a'];

        //other numbers
        nums[1] = freq['o' - 'a'] - nums[0] - nums[2] - nums[4];
        nums[3] = freq['t' - 'a'] - nums[2] - nums[8];
        nums[5] = freq['f' - 'a'] - nums[4];
        nums[7] = freq['s' - 'a'] - nums[6];
        nums[9] = freq['i' - 'a'] - nums[5] - nums[6] - nums[8];

        //stringbuilder to hold all digits in S
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            //append the count of i to sb
            while (nums[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
