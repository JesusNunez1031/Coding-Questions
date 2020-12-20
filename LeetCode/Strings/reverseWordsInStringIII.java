public class reverseWordsInStringIII {
    /*
    Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
    whitespace and initial word order.

    Example 1:
    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     */
    //TC: O(n * m) where n is the length of s and m are the number of words in s
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int i = 0;  //start index of the section to reverse in character array
        for (int j = 0; j < str.length; j++) {
            /*
                when a space is encountered, we know we've reached the end of a word, so we reverse the substring from i
                to j - 1 which is the last character of the word
             */
            if (str[j] == ' ') {
                reverse(str, i, j - 1);
                i = j + 1;  //move i to the first character of the next word
                //when we reach the end, we need to reverse the last word since there are no more spaces to indicate a new word
            } else if (j == str.length - 1) {
                reverse(str, i, j);
            }
        }
        return String.valueOf(str);
    }

    //Method to reverse a section of a char array from index "left" to index "right"
    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}
