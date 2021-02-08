import java.util.Iterator;

public class peekIterator {
    /*
    Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
    support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

    Example:
    Assume that the iterator is initialized to the beginning of the list: [1,2,3].

    Call next() gets you 1, the first element in the list.
    Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
    You call next() the final time and it returns 3, the last element.
    Calling hasNext() after that should return false.

    Follow up: How would you extend your design to be generic and work with all types, not just integer?
    */

    class PeekingIterator<T> implements Iterator<T> {
        //initialize an iterator object and a generic variable to hold the next value in the iterator
        Iterator<T> iter;
        T next = null;

        public PeekingIterator(Iterator<T> iterator) {
            this.iter = iterator;

            //if the iter has a value, initialize next to it
            if (hasNext()) {
                next = iter.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public T peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public T next() {
            T value = next; //save the reference of next before advancing iterator
            if (iter.hasNext()) {
                next = iter.next();
            } else {
                next = null;
            }
            return value;
        }

        @Override
        public boolean hasNext() {
            return next != null || iter.hasNext();
        }
    }
}
