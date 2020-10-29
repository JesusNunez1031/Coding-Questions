public class sumOfFirstNthTermOfSeries {
    public static String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }
        double sum = 0;
        double i = 0;

        while (i < n) {
            sum += 1 / ((3 * i++) + 1);
        }

        return String.format("%.2f", sum);
    }

    public static void main(String[] args) {
        System.out.println(seriesSum(5));
    }
}
