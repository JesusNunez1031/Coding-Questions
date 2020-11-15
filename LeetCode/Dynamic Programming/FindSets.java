public class FindSets {

    //Dynamic program to find sets of values that add up to a specific given number
    public static int countSets(int[] array, int total) {
        return countSetsHelper(array, total, array.length - 1);
    }

    public static int countSetsHelper(int[] array, int total, int i) {
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (i < 0) {
            return 0;
        } else if (total < array[i]) {
            return countSetsHelper(array, total, i - 1);
        } else {
            return countSetsHelper(array, total - array[i], i - 1) +
                    countSetsHelper(array, total, i - 1);
        }
    }
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 10,12};

        System.out.println(countSets(array, 12));
    }
}
