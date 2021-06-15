import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {
    /*
    You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] =
    [numberOfBoxesi, numberOfUnitsPerBoxi]:
        - numberOfBoxesi is the number of boxes of type i.
        - numberOfUnitsPerBoxi is the number of units in each box of the type i.
    You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can
    choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

    Return the maximum total number of units that can be put on the truck.

    Example 1:
    Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
    Output: 8
    Explanation: There are:
    - 1 box of the first type that contains 3 units.
    - 2 boxes of the second type that contain 2 units each.
    - 3 boxes of the third type that contain 1 unit each.
    You can take all the boxes of the first and second types, and one box of the third type.
    The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.

    Example 2:
    Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
    Output: 91

    Constraints:
        1 <= boxTypes.length <= 1000
        1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
        1 <= truckSize <= 10^6
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int max = 0;
        int size = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        //add all the boxes to the heap where the boxes with most units will be at the top
        Collections.addAll(heap, boxTypes);

        while (size < truckSize) {
            //add boxes to the truck if adding them does not exceed the limit
            if (size + heap.peek()[0] < truckSize) {
                int[] load = heap.remove();
                size += load[0];
                max += load[0] * load[1];
            } else {
                //add one box at a time until the limit is reached or the number of boxes is depleted
                int i = 0;
                while (i < heap.peek()[0] && size < truckSize) {
                    size++;
                    max += heap.peek()[1];
                    i++;
                }

                //if all the boxes were used from the current boxType, remove it from the heap
                if (i == heap.peek()[0]) {
                    heap.remove();
                }
            }
        }
        return max;
    }

    public int maximumUnitsEz(int[][] boxTypes, int truckSize) {
        int maxTruckSize = (int) 1e3 + 1;
        int[] buckets = new int[maxTruckSize];

        /*
            add the number of boxes boxType[0] that can be used for the specified units boxType[1]
        */
        for (int[] boxType : boxTypes) {
            buckets[boxType[1]] += boxType[0];
        }

        int max = 0, capacity = truckSize;

        // i is the number of units, buckets[i] holds number of boxes that are available
        for (int i = maxTruckSize - 1; i >= 1; i--) {
            if (buckets[i] > 0) {
                /*
                    if the current bucket has more boxes than can be held, use "capacity" boxes that are left to be
                    used * the value of units i, we don't have to worry if there is a larger unit since the search starts
                    from the end
                */
                if (buckets[i] > capacity) {
                    max += i * capacity;
                    return max;
                } else {
                    //if there is still space in the truck, i.e. capacity > buckets[i], use the number of buckets available
                    max += buckets[i] * i;
                }

                //reduce the capacity by the number of buckets that have been used
                capacity -= buckets[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        maximumUnits(boxTypes, 4);
    }
}
