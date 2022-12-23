package codingbat.warmup_2;

public class stringSplosion {

    /*
    Given a non-empty string like "Code" return a string like "CCoCodCode".

    codingbat.warmup_2.stringSplosion("Code") → "CCoCodCode"
    codingbat.warmup_2.stringSplosion("abc") → "aababc"
    codingbat.warmup_2.stringSplosion("ab") → "aab"
     */
    public String stringSplosion(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= str.length(); i++) {
            result.append(str, 0, i);
        }
        return result.toString();
    }

}
