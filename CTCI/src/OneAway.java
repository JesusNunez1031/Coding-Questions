public class OneAway {

    /*
    Given two string check if they are one edit, insertion, or deletion away from matching
    Ex:
    cale, cal -> true
    pole, poles -> true
    cars, cartes -> false
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
