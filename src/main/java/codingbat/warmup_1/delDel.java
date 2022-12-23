package codingbat.warmup_1;

public class delDel {

    /*
    Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted. Otherwise, return the string unchanged.

    codingbat.warmup_1.delDel("adelbc") → "abc"
    codingbat.warmup_1.delDel("adelHello") → "aHello"
    codingbat.warmup_1.delDel("adedbc") → "adedbc"
     */

    public String delDel(String str) {
        if (str.length() >= 4 && str.startsWith("del", 1)) {
            return str.replace("del", "");
        }
        return str;
    }
}
