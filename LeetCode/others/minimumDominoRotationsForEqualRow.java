import java.util.Arrays;

public class minimumDominoRotationsForEqualRow {
    public static boolean isAllEqual(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[0] != a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int[] Acopy = Arrays.copyOf(A, A.length);
        int[] Bcopy = Arrays.copyOf(B, B.length);

        int[] Acopy2 = Arrays.copyOf(A, A.length);
        int[] Bcopy2 = Arrays.copyOf(B, B.length);
        int swaps1 = 0;
        int swaps2 = 0;
        int temp;
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] == B[i + 1]) {
                temp = Acopy[i + 1];
                Acopy[i + 1] = Bcopy[i + 1];
                Bcopy[i + 1] = temp;
                swaps1++;
            }
        }
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i + 1] == B[i]) {
                temp = Bcopy2[i + 1];
                Bcopy2[i + 1] = Acopy2[i + 1];
                Acopy2[i + 1] = temp;
                swaps2++;
            }
        }
        return isAllEqual(Acopy) || isAllEqual(Bcopy)  || isAllEqual(Acopy2) || isAllEqual(Bcopy2) ? Math.min(swaps1, swaps2) : -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2, 4, 2, 2};
        int[] B = {5, 2, 6, 2, 3, 2};

        System.out.println(minDominoRotations(A, B));
    }
}
