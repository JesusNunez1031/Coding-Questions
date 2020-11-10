public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] freq = new int[128];

        for (int c : s.toCharArray()) {
            freq[c]++;
        }

        for (int j : t.toCharArray()) {
            if (freq[j] == 0) {
                return false;
            } else {
                freq[j]--;
            }
        }

        for (int j : freq) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";

        System.out.println(isAnagram(s, t));
    }
}
