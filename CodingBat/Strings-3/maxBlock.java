public class maxBlock {
    /*

    Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.

    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0
     */

    public static int maxBlock(String str) {
        int blocks = 1;
        int current_max = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                blocks++;
            } else {
                current_max = Math.max(current_max, blocks);
                blocks = 1;
            }
        }
        return current_max;
    }

    public static void main(String[] args) {
        String a = "xyzz";

        System.out.println(maxBlock(a));

    }
}
