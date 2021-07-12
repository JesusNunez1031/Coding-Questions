import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /*
    The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value
    and the median is the mean of the two middle values.

    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
    Implement the MedianFinder class:
        - MedianFinder() initializes the MedianFinder object.
        - void addNum(int num) adds the integer num from the data stream to the data structure.
        - double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will
          be accepted.

    Example 1:
    Input
    ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
    [[], [1], [2], [], [3], []]
    Output
    [null, null, null, 1.5, null, 2.0]

    Explanation
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);    // arr = [1]
    medianFinder.addNum(2);    // arr = [1, 2]
    medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(3);    // arr[1, 2, 3]
    medianFinder.findMedian(); // return 2.0

    Constraints:
    -10^5 <= num <= 10^5
    There will be at least one element in the data structure before calling findMedian.
    At most 5 * 10^4 calls will be made to addNum and findMedian.

    Follow up:
        If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
        If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
     */

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    class MedianFinder {
        //TC: O(log n) time to construct heaps

        /*
            maxheap holds the first half of values and minheap the latter half. THis is so that when the arr = [1,2,3,4,5]

            max_heap: 1 2 3
            min_heap: 5 4

            getting the median will be as simple as getting the top of the max heap, this example is only when arr has
            an odd length. When arr has an even length, the median is the top of max and min
         */
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            //max heap stores the first half of values so when no values have been seen add to the maxHeap
            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }

            /*
                when an even amount of values have been seen both heaps will be equal in size, so when this occurs,
                we want all the first half of values to be in the max heap so if num is greater than the smallest value
                seen so far we remove the min heap value and add it to the max heap and we add the new larger value to
                the min heap to maintain the latter values in the min heap.

                if num is less than the minHeap value, we add it to the maxHeap
             */
            if (maxHeap.size() == minHeap.size()) {
                if (minHeap.peek() < num) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            } else {
                /*
                    when an odd number of values have been seen, max heap will have more values so if the new value num
                    is less than the largest value in the max heap, we add this larger value to the minheap and add the
                    new value to the max heap

                    if num is larger than the largest value in maxheap, we add it to the minheap
                 */
                if (num < maxHeap.peek()) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }

        public double findMedian() {
            //when an even amount of values have been seen, the median is the sum of the two middle values divided by 2
            if (maxHeap.size() == minHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }

            /*
                when an odd amount of values have been seen, the median is the only value from the maxHeap, since the max
                heap stores the first half of the values while the minHeap stores the latter half
             */
            return (double) maxHeap.peek();
        }
    }

}
