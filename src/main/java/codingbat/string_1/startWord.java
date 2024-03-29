package codingbat.string_1;

public class startWord {
    /*

Given a string and a second "word" string, we'll say that the word matches the string if it appears at the front of the string, except its first char does not need to match exactly. On a match, return the front of the string, or otherwise return the empty string. So, so with the string "hippo" the word "hi" returns "hi" and "xip" returns "hip". The word will be at least length 1.

    codingbat.string_1.startWord("hippo", "hi") → "hi"
    codingbat.string_1.startWord("hippo", "xip") → "hip"
    codingbat.string_1.startWord("hippo", "i") → "h"
     */
    public String startWord(String str, String word) {
        if(str.length() < 1|| str.length() < word.length()){
            return "";
        }
        if(str.startsWith(word)){
            return word;
        }
        final boolean equals = str.substring(1, word.length()).equals(word.substring(1));
        if(!equals){
            return "";
        }
        return str.substring(0, word.length());
    }
}
