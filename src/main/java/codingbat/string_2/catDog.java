package codingbat.string_2;

public class catDog {
    /*
    Return true if the string "cat" and "dog" appear the same number of times in the given string.

    codingbat.string_2.catDog("catdog") → true
    codingbat.string_2.catDog("catcat") → false
    codingbat.string_2.catDog("1cat1cadodog") → true
     */
    public boolean catDog(String str) {
        int counterDog = 0;
        int counterCat = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.startsWith("cat", i))
                counterCat++;
            else if (str.startsWith("dog", i))
                counterDog++;
        }
        return counterDog == counterCat;
    }
}
