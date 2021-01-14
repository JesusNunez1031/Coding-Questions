import java.util.Arrays;

public class boatsToSavePeople {
    /*
    The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

    Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

    Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

    Example 1:
    Input: people = [1,2], limit = 3
    Output: 1
    Explanation: 1 boat (1, 2)

    Example 2:
    Input: people = [3,2,2,1], limit = 3
    Output: 3
    Explanation: 3 boats (1, 2), (2) and (3)

    Example 3:
    Input: people = [3,5,3,4], limit = 5
    Output: 4
    Explanation: 4 boats (3), (3), (4), (5)

    Note:
        1 <= people.length <= 50000
        1 <= people[i] <= limit <= 30000
     */
    //TC:O(n log n)
    private int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);    //sort the people so we get lightest to heaviest
        int boats = 0;
        int lightest = 0;
        int heaviest = people.length - 1;

        while (lightest <= heaviest) {
            /*
                if we can add the lightest and heaviest person onto the boat, we move to the next lightest and heaviest,
                otherwise, we just move to the next heaviest since the current heaviest needed a boat of its own.
             */
            if (people[lightest] + people[heaviest] <= limit) {
                lightest++;
                heaviest--;
            } else {
                heaviest--;
            }
            boats++;
        }
        return boats;
    }

    //TC:O(n)
    private int numRescueBoatsEz(int[] people, int limit) {
        //Sort people using count sort//
        int[] count = new int[limit + 1];   //1 <= people[i] <= limit
        //add the count of each persons weight to count array
        for (int peep : people) {
            count[peep]++;
        }
        int index = 0;
        //update the people array to start from lightest to heaviest
        for (int i = 1; i <= limit; i++) {
            while (count[i]-- > 0) {
                people[index++] = i;
            }
        }

        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boats++;
        }
        return boats;
    }
}
