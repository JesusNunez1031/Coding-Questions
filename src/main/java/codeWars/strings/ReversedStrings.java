package codeWars.strings;

public class ReversedStrings {
    /*
     Complete the solution so that it reverses the string value passed into it
     Examples:
      'world' => 'dlrow'
      'hello' => 'olleh'
      'word' => 'drow'
     */
    public static String solution(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] arr = str.toCharArray();

        // swap the first and last characters and move towards the middle
        while (i <= j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }
}
