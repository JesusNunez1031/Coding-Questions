import java.util.Scanner;

public class IntroJava {
    public static void formatText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Justify left 15 spaces and print nums with leading/trailing zeros
            System.out.printf("%-15s%03d\n", s1, x);
        }
        System.out.println("================================");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void multiplication() {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", N, i, N * i);
        }

        scanner.close();
    }

    public static void printSeries() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = a;
            for (int j = 0; j < n; j++) {
                sum += Math.pow(2, j) * b;
                System.out.printf("%s ", sum);
            }
            System.out.println();
        }
        in.close();
    }

    public static void javaRangeDataType() {

        /*
        For each input variable  and appropriate primitive , you must determine if the given primitives are capable of storing it. If yes, then print:
                            n can be fitted in:
                            * dataType
         */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                if (x >= -32768 && x <= 32767) System.out.println("* short");
                if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1) System.out.println("* int");
                if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1) System.out.println("* long");
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }

    public static void readFromScanner() {
        Scanner scan = new Scanner(System.in);
        int i = 1;
        while (scan.hasNext()) {
            System.out.printf("%d %s\n", i, scan.nextLine());
            i++;
        }
    }

    public static boolean verifyPhoneNumber(String num){
        return num.matches("[0-9]{3}-[0-9]{4}");
    }

    public static void main(String[] args) {

    }
}
