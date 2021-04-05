import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class breakCamelCase {
    /*
    Complete the solution so that the function will break up camel casing, using a space between words.

    Example
    solution("camelCasing")  ==  "camel Casing"
     */
    public static String camelCase(String input) {
        if (input.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(" ");
            }
            sb.append(c);
        }
        return sb.toString();
    }

    @Test
    public void tests() {
        assertEquals( "Incorrect", "camel Casing", breakCamelCase.camelCase("camelCasing"));
        assertEquals( "Incorrect", "camel Casing Test", breakCamelCase.camelCase("camelCasingTest"));
        assertEquals( "Incorrect", "camelcasingtest", breakCamelCase.camelCase("camelcasingtest"));
    }
}
