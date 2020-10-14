import java.util.HashMap;

public class ransomNote {
    /*
    Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting.
    He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
    The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.

    Given the words in the magazine and the words in the ransom note, print "Yes" if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print "No".

    For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". The magazine has all the right words, but there's a case mismatch. The answer is "No".
     */

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<>();
        boolean flag = true;

        for (String word : magazine) {
            if (!(map.containsKey(word))) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        for (String words : note) {
            if (!(map.containsKey(words))) {
                flag = false;
                break;
            } else if (map.containsKey(words) && map.get(words) <= 0) {
                flag = false;
                break;
            } else {
                map.put(words, map.get(words) - 1);
            }
        }

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    //return mapA.entrySet().containsAll(mapB.entrySet());
}
