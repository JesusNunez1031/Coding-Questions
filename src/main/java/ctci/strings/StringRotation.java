package ctci.strings;

public class StringRotation {

    /*
    Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
    of another. Given two strings, 51 and 52, write code to check if s2 is a rotation of s1 using only one
    call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat").
     */

    /*
        If we double the size of s1 by making a new string of two times the string in s1, then
        s2 will always be a substring of the new doubleS1

        Ex: if we assume that xy is s1 so, s1 = xy = Because
            x = Beca and y = use
            and s2 bing yx -> useBeca
            then xyxy = BecauseBecause and the substring s2 regardless of where it might have been rotated,
            will always be found in xyxyx or dS1

     */
    public static boolean isRotation(String s1, String s2) {
        //Check if s1 and s2 are equal and the lengths are greater than 0
        if(s1.length() == s2.length() && s1.length() > 0) {
            String dS1 = s1 + s1;
            return isSubstring(dS1, s2);
        }
        return false;
    }

    private static boolean isSubstring(String dS1, String s2) {
        return dS1.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "SuperConductor";
        String s2 = "perConductorSu";

        System.out.println(isRotation(s1, s2));
    }
}
