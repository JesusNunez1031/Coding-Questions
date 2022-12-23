package codingbat.array_3;

import java.util.Arrays;

public class squareUp {

    public static int[] squareUp(int n) {
        int[] array = new int[n * n];
        //Control is used to keep track of which section of the array we are in
        int control = n;
        //Counter holds the value that will be inserted in array after n-1 steps
        int counter = 1;

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = counter;
            if (counter > control) {
                array[i] = 0;
            }
            if (counter == n) {
                counter = 0;
                control--;
            }

            counter++;

        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(squareUp(4)));
    }
}
