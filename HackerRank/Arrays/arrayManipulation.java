public class arrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        int[] values = new int[n+2];

        int rows = queries.length;
        int i = 0;

        while (i < rows) {
            values[queries[i][0]] += queries[i][n - 1];
            values[queries[i][1]+1] -= queries[i][n - 1];
            i++;
        }
        int max = Integer.MIN_VALUE;
        for (i = 1; i <= n; i++) {
            values[i] += values[i - 1];
            max = Math.max(values[i], max);
        }

        return max;

    }

    public static void main(String[] args) {
        int[][] q = {{1, 5, 3},{4, 8, 7},{6, 9, 1}};

        System.out.println(arrayManipulation(3, q));
    }
}
