import java.util.Scanner;

public class palindromeCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb = sb.reverse();

        if (sb.toString().equals(A)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
