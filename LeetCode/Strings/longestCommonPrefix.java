public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        //Set prefix to the first value in array
        //We make the first value the prefix since its letters will be in the longest prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            //if the prefix is not at the beginning of the next word, reduce prefix by one
            //We do this until we have a match, otherwise
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            //check if the prefix is empty, if it is, return it since that is the shortest prefix
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] array = {"flow", "flower", "flight"};
        String[] array2 = {"dog", "racecar", "car"};


        System.out.println(longestCommonPrefix(array));
        System.out.println(longestCommonPrefix(array2));
    }

}
