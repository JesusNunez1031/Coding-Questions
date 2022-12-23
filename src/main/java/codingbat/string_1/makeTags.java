package codingbat.string_1;

public class makeTags {
    /*

The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example, the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".

    codingbat.string_1.makeTags("i", "Yay") → "<i>Yay</i>"
    codingbat.string_1.makeTags("i", "Hello") → "<i>Hello</i>"
    codingbat.string_1.makeTags("cite", "Yay") → "<cite>Yay</cite>"
     */
    public String makeTags(String tag, String word) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";

        return openTag + word + closeTag;
    }
}
