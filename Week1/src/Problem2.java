public class Problem2 {

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

    public static boolean oneEditAway(String first, String second){
        if(first.length() == second.length()){
            return oneEditReplace(first, second);
        }
        else if(first.length() + 1 == second.length()){
            return oneEditInsert(first, second);
        }
        else if(first.length() - 1 == second.length()){
            return oneEditInsert(second, first);
        }
        return false;
    }

    /*
    Iterate through both stings. If at least two differences are found,
    return false. Otherwise return true
     */
    public static boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for(int i = 0;i < s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /*
    Assume the s2 is the larger string. Iterate through both strings
    with their respective running index. If a difference is found, move
    the s2 index forward by one (simulates that the character at s2 is
    removed). If another difference is found, return false, otherwise return true.
     */
   public static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while(index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }
    public static void main(String[] args){
       String one = "pales";
       String two = "ales";

       System.out.println(oneEditAway(one, two));
    }
}
