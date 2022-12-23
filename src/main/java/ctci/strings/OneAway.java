package ctci.strings;

public class OneAway {

    /*There are three types of edits that can be preformed on strings:
    insert a character, remove a character, or replace a character.
    Given two strings, write a function to check if they are one edit
    (or zero edits) away:

    Examples:
    pale, ple --> true
    pales, pale --> true
    pale, bale --> true
    pale, bae --> false

    Solution:
    if the strings are equal in length call onEditReplace.
    Insert to the first string is the same as deleting to the second string
    and vice versa so just differentiate between the bigger and smaller string.
    If one is bigger than the other by one, call oneEditInsert
    Runtime: O(n)
     */

    public static boolean oneEditAway(String a, String b) {
        if(a.length() == b.length()) {
            return oneEditReplace(a,b);
        }
        else if(a.length() + 1 == b.length()) {
            return oneEditInsert(a, b);
        }
        else if(a.length() - 1 == b.length()) {
            return oneEditInsert(a, b);
        }
        return false;
    }

    public static boolean oneEditReplace(String a, String b) {
        boolean foundDifference = false;
        for(int i = 0;i < a.length();i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    // check if you can insert a character into a to make b
    public static boolean oneEditInsert(String a, String b) {
        int index1 = 0;
        int index2 = 0;
        while(index2 < b.length() && index1 < a.length()) {
            if(a.charAt(index1) != b.charAt(index2)) {
                if(index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(oneEditAway("pale", "pal"));
    }
}
