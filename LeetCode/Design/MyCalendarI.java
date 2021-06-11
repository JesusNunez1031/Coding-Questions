import java.util.TreeMap;

public class MyCalendarI {
    /*
    You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a
    double booking.

    A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

    The event can be represented as a pair of integers start and end that represents a booking on the half-open interval
    [start, end), the range of real numbers x such that start <= x < end.

    Implement the MyCalendar class:
    MyCalendar() Initializes the calendar object.
    boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing
    a double booking. Otherwise, return false and do not add the event to the calendar.

    Example 1:
    Input
    ["MyCalendar", "book", "book", "book"]
    [[], [10, 20], [15, 25], [20, 30]]
    Output
    [null, true, false, true]
    Explanation:
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // return True
        myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
        myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.

    Constraints:
        0 <= start < end <= 10^9
        At most 1000 calls will be made to book.
     */
    /*
        we want the events to be sorted in ascending order so using a TreeMap, where entries are kept sorted by the
        nature of the key value and we can get other entries that are just larger and smaller than a current entry will
        make checking for overlap much easier
    */
    /*
        TC: O(n log n) where n are the calls to book. to get floorEntry and ceilingEntry log n time is required since
        TreeMap is a tree data structure and log n is the depth of the tree assuming we traverse to the bottom most entry
     */
    TreeMap<Integer, Integer> calendar;

    public MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        /*
            check if the new booking overlaps with a booking just before it, i.e. if the start time of the current
            interval is less than the end time of the closest previous interval
        */
        if (calendar.floorEntry(start) != null && start < calendar.floorEntry(start).getValue()) {
            return false;
        }

        /*
            check if the new booking overlaps with a booking just after it, i.e. if the end time of the current
            interval is greater than the start time of the closest next interval
        */
        if (calendar.ceilingEntry(start) != null && end > calendar.ceilingEntry(start).getKey()) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }

    //Method 2 building a Binary Tree where we only add intervals if they fit between other intervals, TC: O(n)
    class MyCalendar {
        class Node {
            Node left;
            Node right;
            int start;
            int end;

            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        Node root;

        public MyCalendar() {
            root = null;
        }

        public boolean book(int start, int end) {
            //if no other intervals present, add the interval
            if (root == null) {
                root = new Node(start, end);
                return true;
            }
            // tree iterator variable
            Node iter = root;
            while (iter != null) {
                //the current interval ends before the root interval so it belongs in the left of the tree
                if (end <= iter.start) {
                    //if the left is null, make a new node for this interval
                    if (iter.left == null) {
                        iter.left = new Node(start, end);
                        return true;
                    }
                    //move to the next left node
                    iter = iter.left;
                }
                //the current interval starts after the root interval so it belongs in the right
                else if (start >= iter.end) {
                    //if the right node is null make a new node for the current interval
                    if (iter.right == null) {
                        iter.right = new Node(start, end);
                        return true;
                    }
                    //move to the next right interval
                    iter = iter.right;
                } else {
                    /*
                        the interval to be added overlaps since either its end time is larger than the start time of the
                        current iter node, or its start time is less than iter nodes end time
                     */
                    return false;
                }
            }
            return true;
        }
    }
}
