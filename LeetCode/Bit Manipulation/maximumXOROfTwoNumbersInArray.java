/*
    Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

    Follow up: Could you do this in O(n) runtime?

    Example 1:
    Input: nums = [3,10,5,25,2,8]
    Output: 28
    Explanation: The maximum result is 5 XOR 25 = 28.

    Example 2:
    Input: nums = [0]
    Output: 0

    Example 3:
    Input: nums = [2,4]
    Output: 6

    Example 4:
    Input: nums = [8,10,2]
    Output: 10

    Example 5:
    Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
    Output: 127

    Constraints:
        1 <= nums.length <= 2 * 10^4
        0 <= nums[i] <= 2^31 - 1
 */
class Trie {
    static class TrieNode {
        //tree of bits, branches hold all the values represented as 32-bit bits in the tree
        TrieNode[] children = new TrieNode[2];
    }

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //insert num to the trie of bits
    public void insert(int num) {
        TrieNode iter = root;   //node used to search through trie

        //start from the MSB, left most bit, of nums
        for (int i = 31; i >= 0; i--) {

            //gets the next bit to insert in trie
            int bit = (num >> i) & 1;

            //if the current bit in the path does not exist, add it
            if (iter.children[bit] == null) {
                iter.children[bit] = new TrieNode();
            }

            //move to next bit
            iter = iter.children[bit];
        }
    }

    public int getMaxXor(int num) {
        TrieNode iter = root;   //node used to search through trie
        int xor = 0;    //holds the longest path of bits

        for (int i = 31; i >= 0; i--) {
            //gets the next bit to search for in trie
            int bit = (num >> i) & 1;

            //we always want to look for the opposite bit of "bit" so if bit == 0, we look for 1, and vise versa
            if (bit == 0) {
                //if the opposite bit to 0 for the current path is in the trie
                if (iter.children[bit + 1] != null) {
                    /*
                        equivalent to raising 2 to the power of i, we do this to generate the resulting number of xoring
                        "num" to the value branch of its opposite bits.
                        Ex: [3,10,5,25,2,8], max result here is 5 ^ 25 = 28, when we pass 5, 5's bits will generate 25's
                        branch of bits and this will be equivalent to 5 ^ 25
                    */
                    xor += (1 << i);
                    iter = iter.children[bit + 1];
                } else {
                    //if 1 is not in current path, move to next bit "bit"
                    iter = iter.children[bit];
                }
            } else {
                //if the opposite bit to 1 for the current path is in the trie
                if (iter.children[bit - 1] != null) {
                    xor += (1 << i); //equivalent to raising 2 to the power of i
                    iter = iter.children[bit - 1];
                } else {
                    //if 0 is not in the current path, move to next bit "bit"
                    iter = iter.children[bit];
                }
            }
        }
        return xor;
    }
}

public class maximumXOROfTwoNumbersInArray {

    //TC: O(32n) in the worst case 32 possible bits if all are only 1 specific bit, therefore O(n)
    private static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        int maxXor = -1;

        //add all values to the trie
        for (int num : nums) {
            trie.insert(num);
        }

        /*
            for every value in nums, we need to check its bits and generate the highest value of opposite bits that are
            in the trie given the path of num bits.
            Ex:
                if the trie holds the values 0, 1, 2, 4, assume only 3 bits for this example,
                    000
                    001
                    010
                    100
                the highest xor value will be he longest path in the in the tree of inverse bits of a given value, when we call
                getMaxXor() on 0, we search for a path 111, when we call on 1, we search for a path 110, on 2, path 101, 4, path 011
        */
        for (int num : nums) {
            maxXor = Math.max(maxXor, trie.getMaxXor(num));
        }

        return maxXor;
    }

    //TC: O(n^2) cheap method of finding the value by comparing all values to each other
    private int findMaximumXOREz(int[] nums) {
        int maxor = 0;  //stores the highest xor value

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maxor = Math.max(maxor, nums[i] ^ nums[j]);
            }
        }
        return maxor;
    }
    public static void main(String[] args) {
        int[] arr = {3,10,5,25,2,8};
        System.out.println(findMaximumXOR(arr));
    }
}
