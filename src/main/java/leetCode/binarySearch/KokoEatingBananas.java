package leetCode.binarySearch;

public class KokoEatingBananas {
    /*
    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and
    will come back in h hours.

    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
    from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas
    during this hour.

    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

    Return the minimum integer k such that she can eat all the bananas within h hours.

    Example 1:
    Input: piles = [3,6,7,11], h = 8
    Output: 4

    Example 2:
    Input: piles = [30,11,23,4,20], h = 5
    Output: 30

    Example 3:
    Input: piles = [30,11,23,4,20], h = 6
    Output: 23

    Constraints:
    1 <= piles.length <= 10^4
    piles.length <= h <= 10^9
    1 <= piles[i] <= 10^9
     */
    /*
        TC: O(n * log m) where n is the number of times we check if 'mid' is enough time to eat piles before hours h,
        and log m is the number of times we reduce the search space
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            if (right < pile) {
                right = pile;
            }
        }

        while (left < right) {
            int mid = left + (right - left) / 2; // eating speed

            /*
                check if using a speed of 'mid' to eat piles allows us to eat all the piles under h hours, if so we increase
                koko's time to eat, otherwise we use 'mid' as the upper bound
             */
            if (!canFinish(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // left is the minimum workable eating speed
        return left;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int timeSpent = 0;

        // calculate the time it takes to eat all the piles when using k time to eat each pile
        for (int pile : piles) {
            //timeSpent += Math.ceil((double) pile / k);
            timeSpent += (pile + k - 1) / k; // calculate ceil number
        }
        return timeSpent <= h;
    }
}
