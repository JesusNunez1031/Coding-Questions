package codingbat.warmup_2;

public class altPairs {
    /*
    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".

    codingbat.warmup_2.altPairs("kitten") → "kien"
    codingbat.warmup_2.altPairs("Chocolate") → "Chole"
    codingbat.warmup_2.altPairs("CodingHorror") → "Congrr"
     */
    public String altPairs(String str) {
        StringBuilder sb = new StringBuilder();
        int div = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i % 4 == 0) {
                sb.append(str.charAt(i));
            } else if (i % div == 0) {
                sb.append(str.charAt(i));
                div += 4;
            }
        }
        return sb.toString();
    }
}
