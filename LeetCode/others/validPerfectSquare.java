public class validPerfectSquare {
    /*
    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Follow up: Do not use any built-in library function such as sqrt.
     */
    public boolean isPerfectSquare(int num) {
        int i = 1;
        long result = 0;

        while (result <= num) {
            result = (long) i * i;
            if (result == num) {
                return true;
            }
            i++;
        }
        return false;
    }
}
