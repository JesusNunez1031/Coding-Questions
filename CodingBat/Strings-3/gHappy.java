public class gHappy {
/*
    We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy.

    gHappy("xxggxx") → true
    gHappy("xxgxx") → false
    gHappy("xxggyygxx") → false
 */
    public boolean gHappy(String str) {

        boolean gHappy = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                if (i > 0 && str.charAt(i - 1) == 'g') {
                    gHappy = true;
                } else if (i < str.length() - 1 && str.charAt(i + 1) == 'g') {
                    gHappy = true;
                } else {
                    gHappy = false;
                }
            }
        }
        return gHappy;
    }

}
