package leetCode.greedyAlgorithms;

public class brokenCalculator {
    /*
    On a broken calculator that has a number showing on its display, we can perform two operations:
        - Double: Multiply the number on the display by 2, or;
        - Decrement: Subtract 1 from the number on the display.
    Initially, the calculator is displaying the number X.

    Return the minimum number of operations needed to display the number Y.

    Example 1:
    Input: X = 2, Y = 3
    Output: 2
    Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

    Example 2:
    Input: X = 5, Y = 8
    Output: 2
    Explanation: Use decrement and then double {5 -> 4 -> 8}.

    Example 3:
    Input: X = 3, Y = 10
    Output: 3
    Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.

    Example 4:
    Input: X = 1024, Y = 1
    Output: 1023
    Explanation: Use decrement operations 1023 times.

    Note:
        1 <= X <= 10^9
        1 <= Y <= 10^9
     */
    //TC: O(log Y) and constant time using recursion
    public int brokenCalcRec(int X, int Y) {
        //when X > Y we can return the difference between X-Y as one operation is needed
        if (X >= Y) {
            return X - Y;
        }
        // if Y is even, call the method with with half the value of Y and X, +1 to account for the operation done
        if (Y % 2 == 0) {
            return 1 + brokenCalcRec(X, Y / 2);
        }
        //when Y is odd, call the method by just incrementing 1 to Y and
        return 1 + brokenCalcRec(X, Y + 1);
    }

    //TC: O(log Y) and constant time
    public int brokenCalc(int X, int Y) {
        int operations = 0; //number of operations done

        //reduce Y until its <= to X
        while (Y > X) {
            operations++;   //inc operations to reflect the addition or division done to Y
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
        }
        //now that X > Y, the difference between them will yield the number of times we need to decrement X to get to Y
        return operations + (X - Y);
    }
}
