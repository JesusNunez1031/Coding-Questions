public class IsUnique {

    //Check if all the characters in a string are unique

    public static boolean isUnique(String value) {
        // Cant have
        if(value.length() > 128) { return false; }
        boolean[] alpha = new boolean[128];

        for(int i = 0; i < value.length();i++){
            int ascii = value.charAt(i);
            if (alpha[ascii]) {
                return false;
            }
            alpha[ascii] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(isUnique("hecpaitl"));
    }
}
