package leetCode.slidingWindow_twoPointer;

public class MaximumPointsYouCanObtainFromCards {
    /*
    There are several cards arranged in a row, and each card has an associated number of points The points are given in
    the integer array cardPoints.

    In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

    Your score is the sum of the points of the cards you have taken.

    Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

    Example 1:
    Input: cardPoints = [1,2,3,4,5,6,1], k = 3
    Output: 12
    Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will
    maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of
    1 + 6 + 5 = 12.

    Example 2:
    Input: cardPoints = [2,2,2], k = 2
    Output: 4
    Explanation: Regardless of which two cards you take, your score will always be 4.

    Example 3:
    Input: cardPoints = [9,7,7,9,7,7,9], k = 7
    Output: 55
    Explanation: You have to take all the cards. Your score is the sum of points of all cards.

    Example 4:
    Input: cardPoints = [1,1000,1], k = 1
    Output: 1
    Explanation: You cannot take the card in the middle. Your best score is 1.

    Example 5:
    Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
    Output: 202

    Constraints:
        1 <= cardPoints.length <= 10^5
        1 <= cardPoints[i] <= 10^4
        1 <= k <= cardPoints.length
     */
    //TC: O(n) and O(1) space
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        //get the total sum of all the card points
        int totalPoints = 0;
        for (int point : cardPoints) {
            totalPoints += point;
        }

        //if there are only k cards in the list of cards, directly return the count of points
        if (n == k) {
            return totalPoints;
        }

        /*
            maxPoints stores the max number of points we can make using k cards, windowSum keeps track of the sum of a
            contiguous array of cards of size n - k where n is the size of all the cards and k is the number of cards we
            can use.
         */
        int maxPoints = 0, windowSum = 0;

        for (int i = 0; i < n; i++) {
            windowSum += cardPoints[i]; //add to the current window

            /*
                when the window reaches a size of n - k, we check if the sub-array produces more points than a previous
                window, then the first value in the window is removed so we can add the next ith + 1 value
            */
            if (i >= n - k - 1) {
                maxPoints = Math.max(maxPoints, totalPoints - windowSum);
                windowSum -= cardPoints[i - (n - k - 1)];
            }
        }
        return maxPoints;
    }
}
