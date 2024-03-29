package codingbat.warmup_1;

public class stringE {

    /*

Return true if the given string contains between 1 and 3 'e' chars.

    codingbat.warmup_1.stringE("Hello") → true
    codingbat.warmup_1.stringE("Heelle") → true
    codingbat.warmup_1.stringE("Heelele") → false
     */

    public boolean stringE(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                counter++;
            }
        }
        return (counter >= 1 && counter <= 3);
    }
}
