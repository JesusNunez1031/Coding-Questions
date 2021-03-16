import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class encodeAndDecodeTinyURL {
    /*
    Note: This is a companion problem to the System Design problem: Design TinyURL.
    TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
    it returns a short URL such as http://tinyurl.com/4e9iAk.

    Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
    algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded
    to the original URL.
     */
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

    //TC: O(1) and O(n) space to store all Urls
    public class Codec {
        String prefix = "http://tinyurl.com/"; //prefix of the tiny url
        Random rand = new Random();
        Map<String, String> map = new HashMap<>(); //map key is the encoded url and its value is the original url

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            /*
                the tinyUrl extension we create is of length 10 and is comprised of special symbols, upper and lower case
                letters and digits
             */
            int length = 10;
            String symbol = "-/.^&*_!@%=+>)";
            String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String small_letter = "abcdefghijklmnopqrstuvwxyz";
            String digits = "0123456789";

            StringBuilder sb = new StringBuilder();

            //create one huge string so we can choose random letters to make the extension
            sb.append(symbol).append(cap_letter).append(small_letter).append(digits);

            char[] extension = new char[length]; //char array holds the extension part of the url

            //for every character, choose a random character from the sb string
            for (int i = 0; i < length; i++) {
                extension[i] = sb.charAt(rand.nextInt(sb.length()));
            }
            //combine the prefix and the extension to make an encoded url
            String encoded = prefix + new String(extension);
            //System.out.println(encoded);

            //place the encoded url in the map and the original url as its value and return the encoded url
            map.put(encoded, longUrl);

            return encoded;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }
}
