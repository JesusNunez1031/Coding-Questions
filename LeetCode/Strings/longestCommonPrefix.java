public class longestCommonPrefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Constraints:
        0 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] consists of only lower-case English letters.
     */

    //TC: O(n)
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //The first word in strs must contain the prefix so we start with a prefix of strs[0]
        String prefix = strs[0];

        //for every word in the array, we reduce the prefix until "prefix" is found in strs[i]
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            //check if the prefix is empty, if it is, return it since that is the shortest prefix
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    //Method using a string builder object, O(n) time and space
    public String longestCommonPrefixEz(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        //the first string must include the prefix so we set it as the prefix
        StringBuilder prefix = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix.toString()) != 0) {
                prefix.setLength(prefix.length() - 1);
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] array = {"flow", "flower", "flight"};
        String[] array2 = {"dog", "racecar", "car"};


        System.out.println(longestCommonPrefix(array));
        System.out.println(longestCommonPrefix(array2));
    }

}
