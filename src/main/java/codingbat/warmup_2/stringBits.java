package codingbat.warmup_2;

public class stringBits {

    /*
    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".

    codingbat.warmup_2.stringBits("Hello") → "Hlo"
    codingbat.warmup_2.stringBits("Hi") → "H"
    codingbat.warmup_2.stringBits("Heeololeo") → "Hello"
     */

    public String stringBits(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

}
