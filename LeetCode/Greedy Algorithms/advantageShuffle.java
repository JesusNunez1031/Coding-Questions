import java.util.*;

public class advantageShuffle {
    /*
    Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
    Return any permutation of A that maximizes its advantage with respect to B.

    Example 1:
    Input: A = [2,7,11,15], B = [1,10,4,11]
    Output: [2,11,7,15]

    Example 2:
    Input: A = [12,24,8,32], B = [13,25,32,11]
    Output: [24,32,8,12]

    Note:
        1 <= A.length = B.length <= 10000
        0 <= A[i] <= 10^9
        0 <= B[i] <= 10^9
     */
    //TC: O(n log n) since we sort A and B and O(n) space since we store all values in B into a map
    public int[] advantageCount(int[] A, int[] B) {
        /*
            save the original indexes of all values of B so we know the exact index where A has an advantage on B before
            sorting.
            map of values and the order of the indexes where they appear in
        */
        Map<Integer, Queue<Integer>> B_indexes = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            //make a new queue for the value B[i] if B[i] has none
            B_indexes.putIfAbsent(B[i], new LinkedList<>());
            //add the index i of B[i] to the queue of indexes where it shows up
            B_indexes.get(B[i]).add(i);
        }

        /*
            sort the arrays so its easier to find advantages, when A[i] > B[i], we need to get the original index of B[i]
            and place A[i] to reflect A[i] having an advantage on B at this position.
         */
        Arrays.sort(A);
        Arrays.sort(B);

        //resulting advantage "adv" array
        int[] adv = new int[A.length];

        //fill in all values with -1 so we know where there are unused values, i.e. A[i] < B[i]
        Arrays.fill(adv, -1);

        /*
            queue used to keep track of unused values, these values will be used in the end for indexes where there is
            no value A[i] > B[i]
        */
        Queue<Integer> unusedNums = new LinkedList<>();

        int i = 0, j = 0;   //indexes used to traverse A and B

        while (i < A.length && j < B.length) {
            /*
                when A has an advantage on B, we need to add A[i] to where B[j] was originally so we get the first index where B[j]
                was in and set A[i] to this index in the adv array
            */
            if (A[i] > B[j]) {
                //get the first original index of B[j]
                int index = B_indexes.get(B[j]).remove();
                adv[index] = A[i];
                j++;    //move to the next value in B
            } else {
                //A[i] < B[j] so A[i] is unusable
                unusedNums.add(A[i]);
            }
            i++;
        }

        //search for indexes where there are unused values
        for (i = 0; i < A.length; i++) {
            if (adv[i] < 0) {
                adv[i] = unusedNums.remove();
            }
        }
        return adv;
    }
}
