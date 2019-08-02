import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TrailingZeros {

    /* Focus on the number of 5s in prime factors. To solve calculate the floor(n/5)
    * Numbers 25, 125 etc have more than one five, to handle this divide n by 5 and remove all single 5s
    * then divide by 25 to remove extra 5s*/

    public static int TrailingZeroFactorial(int num){
        int count= 0;

        //Divide n by powers of 5 and update count
        for(int i = 5;num / i >= 1;i*=5){
            count += num/i;
        }
        return count;
    }

    public static void mergeSort(int[] arr, int length) {
        if(length < 2) {
            return;
        }
        int mid = length/2;

        //Create the two arrays
        int[] l = new int[mid];
        int[] r = new int[length - mid];

        //Populate the left half of the array
        for(int i = 0; i < mid;i++){
            l[i] = arr[i];
        }

        //Populate the right half of the array
        for(int i = mid; i < length;i++){
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, length-mid);

        merge(arr, l, r, mid, length-mid);
    }

    private static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while(i < left && j < right) {
            if(l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while(j < right) {
            arr[k++] = r[j++];
        }
    }

    @Test
    public void positiveTest() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        TrailingZeros.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }


    public static void main(String[] args) {
        //System.out.println("Number of trailing zeros: " + TrailingZeroFactorial(25));
//        int[] actual = {5, 1, 6, 2, 3, 4};
//        mergeSort(actual, actual.length);
    }

}
