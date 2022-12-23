package codingbat.string_1;

public class frontAgain {
    /*

Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".

    codingbat.string_1.frontAgain("edited") → true
    codingbat.string_1.frontAgain("edit") → false
    codingbat.string_1.frontAgain("ed") → true
     */
    public boolean frontAgain(String str) {
        if(str.length() < 2){
            return false;
        }
        String firstTwo = str.substring(0,2);

        return str.substring(str.length()-2).equals(firstTwo);
    }
}
