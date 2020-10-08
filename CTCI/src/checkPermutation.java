import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class checkPermutation {
    //Given two strings, write a method to decide if one is a permutation
    //of the other

    //Method 1: Sort both strings and check if they are equal to each other
    //Runtime: O(nlogn)

    static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    static boolean isPermutation(String s, String t){
        return sort(s).equals(sort(t));
    }


    //Method 2: Count each character in each string and check if their
    //counts are the same
    //Runtime O(n)
    static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            sCount.put(sChar, sCount.getOrDefault(sChar, 0) + 1);
            tCount.put(tChar, tCount.getOrDefault(tChar, 0) + 1);
        }
        //Character and Integer objects have their equals methods defined
        return sCount.equals(tCount);
    }

    public static void main(String[] args){
        String one = "mta";
        String two = "tam";

        System.out.println(isPermutation(one, two));
        System.out.println(permutation(one, two));
    }
}
