package leetCode.dfs_bfs_topologicalSort;

import java.util.*;

public class OpenTheLock {
    /*
    You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6',
    '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
    Each move consists of turning one wheel one slot.

    The lock initially starts at '0000', a string representing the state of the 4 wheels.

    You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock
    will stop turning and you will be unable to open it.

    Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of
    turns required to open the lock, or -1 if it is impossible.

    Example 1:
    Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    Output: 6
    Explanation:
    A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
    Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
    because the wheels of the lock become stuck after the display becomes the dead end "0102".

    Example 2:
    Input: deadends = ["8888"], target = "0009"
    Output: 1
    Explanation:
    We can turn the last wheel in reverse to move from "0000" -> "0009".

    Example 3:
    Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
    Output: -1
    Explanation:
    We can't reach the target without getting stuck.

    Example 4:
    Input: deadends = ["0000"], target = "8888"
    Output: -1

    Constraints:
        1 <= deadends.length <= 500
        deadends[i].length == 4
        target.length == 4
        target will not be in the list deadends.
        target and deadends[i] consist of digits only.
     */

    //TC: O(1e4) or O(1) since regardless of target or deadends, there will always be 10^4 leetCode.backtracking.combinations
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        //add all the deadends to the set since we need to skip them if encountered
        Set<String> seen = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        queue.add("0000"); // add the first lock to the queue since this is the starting default lock

        //return -1 if the target is a deadend
        if (seen.contains(target)) {
            return -1;
        }

        //number of turns to get to target from '0000'
        int turns = 0;

        /*
            do a bfs search starting from '0000' and update each integer in the lock by adding and subtracting 1,
            depending on where the digit is, i.e. if a digit is 0, adding brings us to 1, subtracting changes it to 9.

            essentially we search through all 10^4 possible leetCode.backtracking.combinations until we either hit the target or exhaust all
            options
        */
        while (!queue.isEmpty()) {
            int size = queue.size();

            //search through all the locks in a current level
            while (size-- > 0) {
                String currentLock = queue.remove();

                //if we have seen this lock, skip it
                if (seen.contains(currentLock)) {
                    continue;
                }
                //if the target lock is found, return the number of turns it took to find it
                if (currentLock.equals(target)) {
                    return turns;
                }

                //add to the queue the next possible leetCode.backtracking.combinations made from the current lock
                for (String nextLock : generateNextLocks(currentLock)) {
                    if (!seen.contains(nextLock)) {
                        queue.add(nextLock);
                    }
                }
                //mark the current lock as seen by adding to the set of seen locks
                seen.add(currentLock);
            }
            //add 1 to the number of turns made
            turns++;
        }
        //target cant be reached
        return -1;
    }

    //Returns the a set of locks that can be made by moving clockwise and counter clockwise on each digit in the current lock
    private Set<String> generateNextLocks(String currentLock) {
        Set<String> newLocks = new HashSet<>();
        char[] lock = currentLock.toCharArray();

        //iterate through the current lock and change each digit by one twice
        for (int i = 0; i < 4; i++) {
            char digit = lock[i];

            //add one to the digit, i.e. move the lock clockwise
            lock[i] = digit == '9' ? '0' : (char) (digit + 1);
            newLocks.add(new String(lock));

            //subtract one from the digit, i.e. move lock couter-clockwise
            lock[i] = digit == '0' ? '9' : (char) (digit - 1);
            newLocks.add(new String(lock));

            //reset the value of ith digit so the next combination does not add on to the changes from the current change
            lock[i] = digit;
        }
        return newLocks;
    }

    public int openLockEz(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        //mark all the deadends as seen to skip them
        boolean[] seen = new boolean[(int) 1e4];
        for (String dead : deadends) {
            seen[Integer.parseInt(dead)] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // add the first lock to the queue

        //convert target to string
        int targ = Integer.parseInt(target);

        //if the start lock or the target are deadends we cant start or end hence we return -1
        if (seen[0] || seen[targ]) {
            return -1;
        }

        //number of turns to get to target from '0000', start at 1 since we've already checked 0
        int turns = 1;

        /*
            do a bfs search starting from '0000' and update each integer in the lock by adding and subtracting 1,
            depending on where the digit is, i.e. if a digit is 0, adding brings us to 1, subtracting changes it to 9.

            essentially we search through all 10^4 possible leetCode.backtracking.combinations until we either hit the target or exhaust all
            options
        */
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Integer currentLock = queue.remove();

                /*
                    since we are working with integer, in order to extract each one of the four digits from the current
                    lock, we move through the current locks digits depending on their place magnitude, e.g. given lock 1234,
                        - 4 is in the one's place hence digit = 1234 % (1 *  10) / 1 = 4

                        - we now need the rest of the lock without this digit 4, i.e. 1234 - (4 * 1) = 1230

                        we now have the digit 4 to add 1 to make the next lock and we also have the value of the lock
                        without digit 4 that will be used to make the next lock

                        on the next iteration, we focus on 3 which is in the 10's place
                 */
                for (int i = 1; i < (int) 1e4; i *= 10) {
                    int digit = currentLock % (i * 10) / i, // depending on the place value of i, that's what the digit will be
                            lock = currentLock - (digit * i); // this is the lock value without the value of "digit"

                    /*
                        we can move clock wise and counter-clock wise for any lock, i.e. if we are at 0 we must move to 9,
                        and if we are at 9 we must move to 0, to do this we once again use modulo to wrap around the next
                        digit. To do this, we add one to the digit when k == 1, and then we add 9 to digit so it wraps
                        around, i.e. if digit = 9 + 9 = 8 so 1 was subtracted from 9.

                        to make the next lock from 1234 to 1235 and 1233 we add 1 then subtract 1 at the position of "digit",
                        clockwise: 1230 + (4 + 1) % 10 = 1235
                        counter-clockwise: 1230 + (4 + 9) % 10 = 1233
                     */
                    for (int k = 1; k < 10; k += 8) {
                        int nextLock = lock + (digit + k) % 10 * i;

                        //if we have seen this lock or its a deadend, skip it
                        if (seen[nextLock]) {
                            continue;
                        }

                        //if the target lock is found, return the number of turns it took to find it
                        if (nextLock == targ) {
                            return turns;
                        }

                        //mark this nextLock as seen and add it to the queue
                        seen[nextLock] = true;
                        queue.add(nextLock);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}
