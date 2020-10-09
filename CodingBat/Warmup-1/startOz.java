public class startOz {
    /*

Given a string, return a string made of the first 2 chars (if present),
however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".

    startOz("ozymandias") → "oz"
    startOz("bzoo") → "z"
    startOz("oxx") → "o"
     */
    public String startOz(String str) {
        if (str.length() < 1) {
            return "";
        } else if (str.length() >= 2 && str.startsWith("oz")) {
            return "oz";
        } else if (str.charAt(0) == 'o') {
            return "o";
        } else if (str.charAt(1) == 'z') {
            return "z";
        }
        return "";
    }


}
