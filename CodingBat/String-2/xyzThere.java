public class xyzThere {
    /*
    Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

    xyzThere("abcxyz") → true
    xyzThere("abc.xyz") → false
    xyzThere("xyz.abc") → true
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
