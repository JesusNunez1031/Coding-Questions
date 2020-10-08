public class countYZ {

    /*

Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive).
We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)

    countYZ("fez day") → 2
    countYZ("day fez") → 2
    countYZ("day fyyyz") → 2
     */
    public int countYZ(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            //Only add to count if the y or z are found at the end of a word, meaning there are no characters after it
            if ((Character.toLowerCase(str.charAt(i)) == 'y' || Character.toLowerCase(str.charAt(i)) == 'z') && !Character.isLetter(str.charAt(i + 1))) {
                count++;
            }
        }
        //if the last characters in the string are y or z, count them aswell
        if (Character.toLowerCase(str.charAt(str.length() - 1)) == 'y' || Character.toLowerCase(str.charAt(str.length() - 1)) == 'z') {
            count++;
        }
        return count;
    }

}
