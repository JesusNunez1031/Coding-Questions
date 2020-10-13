public class countApplesAndOranges {

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int numApples = 0;
        int numOranges = 0;

        for (int i = 0; i < apples.length; i++) {
            apples[i] += a;
            if (apples[i] >= s && apples[i] <= t) {
                numApples++;
            }
        }
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] += b;
            if (oranges[i] >= s && oranges[i] <= t) {
                numOranges++;
            }
        }
        System.out.println(numApples);
        System.out.println(numOranges);

    }
}
