package codingbat.string_2;

public class xyzThere {
    /*
    Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

    codingbat.string_2.xyzThere("abcxyz") → true
    codingbat.string_2.xyzThere("abc.xyz") → false
    codingbat.string_2.xyzThere("xyz.abc") → true
     */
    public boolean xyzThere(String str) {
        if(str.length() >= 3 && str.startsWith("xyz")){
            return true;
        }
        for(int i = 1;i < str.length()-2;i++){
            if(str.charAt(i-1) != '.' && str.startsWith("xyz", i)){
                return true;
            }
        }
        return false;
    }
}
