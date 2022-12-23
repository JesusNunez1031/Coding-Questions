package leetCode.hashMaps;

import java.util.HashMap;
import java.util.Map;

public class frequenciesOfLimitedRangeArrayElements {
    /*
    Given an array A[] of N positive integers which can contain integers from 1 to N where elements can be repeated or
    can be absent from the array. Your task is to count the frequency of all elements from 1 to N.

    Example 1:
    Input:
    N = 5
    A[] = {2,3,2,3,5}
    Output: 0 2 2 0 1
    Explanation:
    Counting frequencies of each array element
    We have:
    1 occurring 0 times.
    2 occurring 2 times.
    3 occurring 2 times.
    4 occurring 0 times.
    5 occurring 1 time.

    Example 2:
    Input:
    N = 4
    A[] = {3,3,3,3}
    Output: 0 0 4 0
    Explanation:
    Counting frequencies of each array element
    We have:
    1 occurring 0 times.
    2 occurring 0 times.
    3 occurring 4 times.
    4 occurring 0 times.
     */
    public static void frequencycount(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            int value = map.get(i) != null && map.get(i) > 0 ? map.get(i) : 0;
            System.out.printf("%d ", value);
        }
    }

    void frequencycount2(int[] arr,int n)
    {
        // Subtract 1 from every element so that the element is in the range from 0 to n-1
        for (int i =0; i<n; i++)
            arr[i] = arr[i]-1;

        // storing the frequency of elements using mathematical formula
        /*
         Use every element arr[i] as index and add 'n' to element present at arr[i]%n to keep track of count of occurrences of arr[i]
         */
        for (int i=0; i<n; i++)
            arr[arr[i]%n] = arr[arr[i]%n] + n;

        //taking out frequency of each element
        for (int i =0; i<n; i++)
            arr[i] = arr[i]/n;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,2,3,5};
        frequencycount(arr, 5);
    }
}
