import java.util.HashSet;

public class SockMerchant {

    // Complete the sockMerchant function below.
    public static int sockMerchant(int n, int[] ar) {
        if(n == 1) {
            return 0;
        }
        int pairs = 0;
        HashSet<Integer> colors = new HashSet<>();

        for(int i = 0; i < n;i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                colors.remove(ar[i]);
                pairs++;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 20,10, 10, 30, 50, 10, 20};

        System.out.println(sockMerchant(arr.length, arr));
    }
}
