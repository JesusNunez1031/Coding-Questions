public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        //Remove all trailing and leading zeros
        s = s.trim();
        int maxLen = 0;

        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                maxLen++;
            }
            else {
                maxLen = 0;
            }
        }
        return maxLen;
    }
}
