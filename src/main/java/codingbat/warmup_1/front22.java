package codingbat.warmup_1;

public class front22 {

    /*
    Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.

    codingbat.warmup_1.front22("kitten") → "kikittenki"
    codingbat.warmup_1.front22("Ha") → "HaHaHa"
    codingbat.warmup_1.front22("abc") → "ababcab"
     */

    public String front22(String str) {
        if (str.length() <= 2) {
            return str + str + str;
        }
        String front = str.substring(0, 2);
        return front + str + front;
    }
}
