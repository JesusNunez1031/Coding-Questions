public class lexicographicalOrder {
    /*
        given a string s, return 2 substrings of size k, the first with the smallest lexicographical order and the other the largest lexicographical order
     */
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        for (int i = 0; i <= s.length() - k; i++) {
            String current = s.substring(i, i + k);
            if (current.compareTo(largest) > 0) {
                largest = current;
            } else if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
        }

        return smallest + "\n" + largest;
    }

}
